package com.example.datastructures.linkedlist;

import java.util.Stack;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/6/30 15:05
 * @version:1.0
 */
// 演示栈 的基本适用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        // 出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }
}
