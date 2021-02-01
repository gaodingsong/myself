package com.example.handler;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/2/1 16:50
 * @version:1.0
 */
@Component
public class TestHandle implements  TypeHandler{
    @Override
    public boolean isMatched(String... type) {
//        return type.length != 0 && Arrays.asList(type).contains(MemberDicEnum.MEMBER_NICKNAME.getDicCodeStr());
        return type.length != 0 && Arrays.asList(type).contains("1");
    }

    @Override
    public void handle(Object obj) {


        System.out.println("test*********************************");

    }
}
