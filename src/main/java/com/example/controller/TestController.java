package com.example.controller;


import com.example.bloomfilter.BloomFilterService;
import com.example.service.ITest2Service;
import com.example.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/test/")
public class TestController {


    @Autowired
    private ITestService testService;


    @Autowired
    private ITest2Service testService2;


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("test1")
    public void test1(String str,int a){
        testService.test1();
    }

    @GetMapping("testRedis")
    public void testRedis(){
        testService.testRedis();
    }

    @GetMapping("testRedis2")
    public void testRedis2(){
        testService.testRedis2();
    }

    @GetMapping("testRedis3")
    public void testRedis3(){
        testService.testRedis3();
    }

    @GetMapping("testQuery")
    public void testQuery(int id ){
        testService.testQuery(id);
    }


    @GetMapping("test5")
    public void test5(){
        testService.test5();
    }


    @GetMapping("test6")
    public void test6(){
        testService.test6();
    }


}
