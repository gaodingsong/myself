package com.example.aqs.s02;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/3/21 10:11 上午
 * @version:1.0
 */
public class Main {


    public static  int m =0;
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                synchronized (Main.class){
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                }
            });

        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();// 让所有线程顺序结束，让所有的线程都执行完了之后再去打印m
        System.out.println(m);

    }
}
