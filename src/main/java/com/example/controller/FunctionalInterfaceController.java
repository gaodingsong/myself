package com.example.controller;

import com.example.entity.linux1.Test;

import java.util.function.Function;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/6 17:25
 * @version:1.0
 */
public class FunctionalInterfaceController {
    public static void main(String[] args) {
        // 函数式接口  // Function 函数式接口 有一个输入参数，有一个输出
        Function<String, String> function = (str)-> str;
        System.out.println(function.apply("aaaa000"));


        int a = 10;


        Test t = new Test();




    }





}
