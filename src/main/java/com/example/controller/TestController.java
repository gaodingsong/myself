package com.example.controller;


import com.example.enumeration.ErrorTypeEnum;
import com.example.expection.MyRuntimeException;
import com.example.service.ITest2Service;
import com.example.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService1;

//    @Autowired
//    private ITest2Service test2Service2;

    @GetMapping("test")
    public void test(){
        testService1.test();
    }

    @GetMapping("/test2")
    public  String test2(){
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new MyRuntimeException(ErrorTypeEnum.PARAM_ERROR.getCode(), ErrorTypeEnum.PARAM_ERROR.getMessage());
        }
        return "nihao";
    }

}
