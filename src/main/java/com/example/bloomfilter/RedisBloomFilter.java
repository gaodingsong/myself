package com.example.bloomfilter;

import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.List;

import static java.util.Objects.hash;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/12 9:50 下午
 * @version:1.0
 */
@Component
public class RedisBloomFilter {

    // 预计插入量
    private long expectedInsertions =1000;

    // 误判率
    private double fpp = 0.001F;

    @Autowired
    private RedisTemplate redisTemplate;

    // bit数组长度
    private long numBits;

    // hash函数数量
    private int numHashFunctions;


    public long getExpectedInsertions() {
        return expectedInsertions;
    }

    public void setExpectedInsertions(long expectedInsertions) {
        this.expectedInsertions = expectedInsertions;
    }

    public double getFpp() {
        return fpp;
    }

    public void setFpp(double fpp) {
        this.fpp = fpp;
    }

    @PostConstruct
    public void init(){
        this.numBits =optimalNumOfBits(expectedInsertions,fpp);
        this.expectedInsertions = optimalNumOfHashFunctions(expectedInsertions,numBits);

    }

    /**
     * 计算数组的长度
     * @param n  预计插入量
     * @param p 容错率
     * @return
     */
    static long optimalNumOfBits(long n, double p) {
        if (p == 0.0D) {
            p = 4.9E-324D;
        }

        return (long)((double)(-n) * Math.log(p) / (Math.log(2.0D) * Math.log(2.0D)));
    }

    /**
     * 计算hash函数的个数
     * @param n 预计插入量
     * @param m 位数组长度
     * @return
     */
    static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int)Math.round((double)m / (double)n * Math.log(2.0D)));
    }


    /**
     * 将key存入redis 的bitmaps
     */
    public void put(String key){
        long[] indexs = getIndexs(key);
        redisTemplate.executePipelined(new RedisCallback<Object>() {

            @Nullable
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                for (long index : indexs) {
                    //  在这里并没有创建位数组的长度，没关系，如果index越界了 redis会自动帮我们扩容
                    // 把对应的下标位置改成1 true就是1  setbit taibai 下标 1
                    redisConnection.setBit("bf:taibai".getBytes(),index,true);
                }
                redisConnection.close();
                return null;
            }
        });

    }

    /**
     * 根据key获取bitmaps下标
     * @param key
     * @return
     */
    private long[] getIndexs(String key) {
        long hash1 = hash(key);
        long hash2 = hash1 >>> 16;
        long[] result = new long[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            long combineHash = hash1 + i * hash2;
            if (combineHash<0){
                combineHash  = ~combineHash;
            }
            result[i] = combineHash % numBits;
        }
        return result;

    }


    /**
     * 判断key是否存在于集合  是返回true 否则返回false
     * @param key
     * @return
     */
    public boolean isExist(String key){

        long[] indexs = getIndexs(key);

        List list = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Nullable
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                for (long index : indexs) {
                    redisConnection.getBit("bf:taibai".getBytes(),index);
                }
                redisConnection.close();
                return null;
            }
        });


        return !list.contains(false);
    }

}
