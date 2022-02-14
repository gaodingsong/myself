package com.example.threadpool;


/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/9 2:26 下午
 * @version:1.0
 */
public class MyTask implements Runnable{

    int i = 0;

    public MyTask(int i){
        this.i = i;

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"========"+ i);
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
