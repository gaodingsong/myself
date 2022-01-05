package com.example.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/4 11:21 上午
 * @version:1.0
 */
public class MyListener implements SpringApplicationRunListener {


    public MyListener(SpringApplication springApplication,String[] args){

    }

    public void starting(){
        System.out.println("程序开始准备了");
    }

    public void started(ConfigurableApplicationContext context) {
        System.out.println("程序开始准备了");
    }


}
