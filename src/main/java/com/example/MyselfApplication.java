package com.example;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class MyselfApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyselfApplication.class, args);
    }

}
