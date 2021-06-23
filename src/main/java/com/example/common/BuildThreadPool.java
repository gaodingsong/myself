package com.example.common;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/19 15:56
 * @version:1.0
 */
public class BuildThreadPool {

    public static final ThreadPoolExecutor threadPoolExecutor(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,// 核心线程池大小
                5,// 最大核心线程池大小
                3,// 超时了没有人调用就失效释放
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()

        );
        return threadPool;
    }
}
