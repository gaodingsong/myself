package com.example.threadpool;

import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.*;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/9 2:26 下午
 * @version:1.0
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(
                10, 20,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
        for (int i = 1; i < 100; i++) {
            threadPoolExecutor4.execute(new MyTask(i));
        }


    }
}
