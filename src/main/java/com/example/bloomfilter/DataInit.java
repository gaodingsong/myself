package com.example.bloomfilter;

import com.example.entity.linux1.Test;
import com.example.service.ITestService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/14 1:56 下午
 * @version:1.0
 */
@Component
public class DataInit {

    @Resource
    private ITestService testService;

    @Resource
    private RedisBloomFilter redisBloomFilter;

    @PostConstruct
    public void init(){
        List<Test> tests = testService.selectAll();
        for (Test test : tests) {
            redisBloomFilter.put(String.valueOf(test.getId()));
        }
    }
}
