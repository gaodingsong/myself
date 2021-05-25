package com.example.designpatterns.chainofresponsibilitypattern;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 17:43
 * @version:1.0
 */
public class ThreeInterview extends Handler{
    @Override
    public void handleRequest(Integer times) {
        if (times == 3) {
            System.out.println("第三次面试"+ times + "，恭喜面试通过，HR会跟你联      系！！！");
        }
    }

    public static void main(String[] args) {
        Handler first = new FirstInterview();
        Handler second = new SecondInterview();
        Handler three = new ThreeInterview();
        first.setHandler(second);
        second.setHandler(three);

        // 第一次面试
        first.handleRequest(1);
        System.out.println();
        // 第二次面试
        first.handleRequest(2);
        System.out.println();
        // 第三次面试
        first.handleRequest(3);
        System.out.println();
    }
}
