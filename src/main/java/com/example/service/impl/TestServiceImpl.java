package com.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.example.bloomfilter.BloomFilterService;
import com.example.entity.Test;
import com.example.entity.Test2;
import com.example.mapper.Test2Mapper;
import com.example.mapper.TestMapper;
import com.example.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-17
 */
@Slf4j
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Autowired
    private TestMapper testMapper;




    @Autowired
    private Test2Mapper testMapper2;

    private volatile static AtomicInteger num2 = new AtomicInteger();

    private ReadWriteLock lock = new ReentrantReadWriteLock() ;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Autowired
    private BloomFilterService bloomFilterService;

    @Override
    public void test1() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","高丁松");


        List<Test> list = testMapper.selectList(queryWrapper);
        for (Test test : list) {
           log.info("参数输出：{}",GsonUtil.toJsonContainNull(test));
        }

    }


    /*
    *     @Async("memberOperLogExecutor")  插入的时候做线程池插入
    * */
    @Override
    public  void testRedis() {

        Integer num = Integer.valueOf(redisTemplate.opsForValue().get("goods"));

        if (num>0){
            String  lastNum = (num-1)+"";
            log.info("剩余：{}",lastNum);
            redisTemplate.opsForValue().set("goods",lastNum);
        }else {
            log.info("暂无商品：{}","数量为0");
        }

    }

    @Override
    public void testRedis2() {
        int andIncrement = num2.getAndIncrement();
        if (andIncrement>20){
            log.info("暂无商品：{}","数量为0");
        }else {
            log.info("商品：{}已出售",andIncrement);
        }
    }

    @Override
    public void testRedis3() {
        lock.readLock().lock();

        Integer num = Integer.valueOf(redisTemplate.opsForValue().get("goods"));

        if (num>0){
            String  lastNum = (num-1)+"";
            log.info("剩余：{}",lastNum);
            redisTemplate.opsForValue().set("goods",lastNum);
        }else {
            log.info("暂无商品：{}","数量为0");
        }



    }

    @Override
    public void testQuery(int id ) {
        if ( bloomFilterService.testIdExists(id)){
            String s = redisTemplate.opsForValue().get("user:user" + id);
            log.info("redis查询结果：{}",s);
            if (StringUtils.isBlank(s)){
                Test test = testMapper.selectById(id);
                redisTemplate.opsForValue().set("user:user"+id,GsonUtil.toJsonContainNull(test),5, TimeUnit.SECONDS);
            }
        }
    }

    @Override
    @DS("db2")
    public void test5() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Test2> testList = testMapper2.selectList(queryWrapper);
        for (Test2 test : testList) {
            System.out.println(test);
        }
    }
    @Override
    public void test6() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<Test> testList = testMapper.selectList(queryWrapper);
        for (Test test : testList) {
            Test2 test2 = new Test2();
            BeanUtils.copyProperties(test,test2);
           testMapper2.insert(test2);
        }



    }
}
