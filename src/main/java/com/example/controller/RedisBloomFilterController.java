package com.example.controller;

import com.example.bloomfilter.RedisBloomFilter;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/14 1:54 下午
 * @version:1.0
 */
@RestController
@RequestMapping("RedisBloomFilter")
@Api(value = "布隆过滤器分布式版",tags = "布隆过滤器分布式版")
public class RedisBloomFilterController {

    @Resource
    private RedisBloomFilter redisBloomFilter;

    @GetMapping("isExist")
    public boolean isExist(String key){
      return   redisBloomFilter.isExist(key);
    }
    @GetMapping("put" )
    public void put(String key){
        redisBloomFilter.put(key);
    }

}
