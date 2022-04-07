package com.example.jmm;

import org.springframework.web.jsf.FacesContextUtils;

/**
 * @author:gaodingsong
 * @description:volatile保证可见性
 * @createTime:2022/2/15 3:36 下午
 * @version:1.0
 */
public class Test3 {

    private static volatile boolean found = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("等基友送笔来。。。");
                while (!found){

                }
                System.out.println("笔来了，开始写字");
            }
        },"我线程").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("基友找到笔来，送过去。。。。。");
                change();
            }
        },"基友线程").start();
    }




    private  static void change() {
        found = true;
    }
}
