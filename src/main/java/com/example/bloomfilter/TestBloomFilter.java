package com.example.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/11 3:51 下午
 * @version:1.0
 */
public class TestBloomFilter {
    private  static int size = 1000000;
    /**
     * size 预计要插入的条数
     * fpp：容错率
     * BloomFilter：位数组
     * list：创建的是Object的数组
     * bit：数组
     */
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,0.001);
    public static void main(String[] args) {
        for (int i = 1; i < size; i++) {
            bloomFilter.put(i);
        }
        List<Integer> list = new ArrayList<>(10000);
        for (int i =  size+10000; i < size+20000; i++) {
            if (bloomFilter.mightContain(i)){
                // 误判
                list.add(i);
            }
        }
        System.out.println("误判的数量"+ list.size());
    }
}
