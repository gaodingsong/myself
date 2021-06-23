package com.example.controller;

import com.example.context.ServiceContextHolder;
import com.example.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/6/23 15:57
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/thread/local")
public class ThreadLocalDemoController {
    @Autowired
    private ITestService testService1;


    @GetMapping("saveToThread")
    public void saveToThread(){
        ServiceContextHolder.createEmptyContext();
        ServiceContextHolder.success("你好，我在测试ThreadLocal");

        testService1.testThreadLocal();


    }



}
