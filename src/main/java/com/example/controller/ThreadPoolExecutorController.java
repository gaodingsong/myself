package com.example.controller;

import com.example.common.BuildThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/6 16:39
 * @version:1.0
 */
public class ThreadPoolExecutorController {
    public static void main(String[] args) {
//
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
//                2,// 核心线程池大小
//                 5,// 最大核心线程池大小
//                 3,// 超时了没有人调用就失效释放
//                TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardOldestPolicy()
//
//        );

        ThreadPoolExecutor threadPool = BuildThreadPool.threadPoolExecutor();

        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                threadPool.execute(()->{

                    // 代码逻辑开始
                    //  ...
                    //代码逻辑结束
                    System.out.println(Thread.currentThread().getName()+"=====>>>"+ finalI);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // 线程池用完，关闭线程池
             threadPool.shutdown();
        }




    }
}
