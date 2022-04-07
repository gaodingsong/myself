package com.example.jmm;

/**
 * @author:gaodingsong
 * @description:volatile不保证原子性
 * @createTime:2022/2/16 5:07 下午
 * @version:1.0
 */
public class VolatileAtomicSample {

    private static volatile int counter = 0;


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    counter++;
                }

            }).start();

        }
        System.out.println(counter);
    }
}
