package com.example.controller;

import cn.hutool.core.date.StopWatch;
import com.example.entity.linux1.Test;
import com.example.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description: 多线程控制器
 * @author:dingsong.gao
 * @createTime:2021/3/31 13:50
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("/multithreading")
public class MultithreadingController {


    public static void main(String[] args) {

        // 自定义线程池：// 工作中创建线程池 用ThreadPoolExecutor去创建
         ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                 // 核心线程池大小
                 4,
                 // 最大核心线程池大小
                  8,
                 // 超时了没有人调用就失效释放
                  3,
                 // 阻塞队列 类似于银行的排队人数 ，如果高于这个人数，则出发，第二个参数 最大支持的线程数
                  TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                 // 创建线程的工厂，一般不会动
                  Executors.defaultThreadFactory(),
                 // 银行满了，还有人进来 就不处理这个人的了跑出异常
                  new ThreadPoolExecutor.CallerRunsPolicy()
                 // 哪来的回哪去
//                  new ThreadPoolExecutor.DiscardPolicy()
                 // 队列满了 丢掉任务 不会抛出异常 new ThreadPoolExecutor.DiscardOldestPolicy()
                 // 队列满了 尝试去和最早的竞争 如果竞争失败 丢掉任务 不会抛出异常
//                  new ThreadPoolExecutor.AbortPolicy()
         );



         List<Test> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {

            Test t = new Test();
            t.setAge(i%2==0?null:18);
            t.setId(i);
            t.setSex(1);
            t.setName("name"+ i);
            list.add(t);
        }


        list.stream().peek(a->a.setAge(a.getAge() ==null?10: a.getAge())).collect(Collectors.toList());
        list.forEach(System.out::println);

//
//        StopWatch stopWatch2 = new StopWatch();
//        stopWatch2.start();
//        for (Test test : list) {
//            System.out.println(GsonUtil.toJsonContainNull(test));
//        }
//
//        stopWatch2.stop();
//        System.out.println("耗时："+stopWatch2.getTotalTimeSeconds());


//       try {
//           StopWatch stopWatch = new StopWatch();
//           stopWatch.start();
//
//
//               for (Test test : list) {
//                   threadPool.execute(()->{
//                       System.out.println( Thread.currentThread().getName() + "====="+GsonUtil.toJsonContainNull(test));
//
//                   });
//               }
//           stopWatch.stop();
//           System.out.println("耗时："+stopWatch.getTotalTimeSeconds());
//       }catch (Exception e){
//           e.printStackTrace();
//       }finally {
//           threadPool.shutdown();
//       }



    }
}
