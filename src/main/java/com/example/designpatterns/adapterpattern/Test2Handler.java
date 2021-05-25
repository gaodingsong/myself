package com.example.designpatterns.adapterpattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 18:22
 * @version:1.0
 */
@Slf4j
@Component
public class Test2Handler implements TypeHandler{


    @Override
    public boolean isMatched(String... type) {
        return type.length != 0 && Arrays.asList(type).contains("2");
    }

    @Override
    public void handle(Object obj) {

        System.out.println("test22222222222222");

    }
}
