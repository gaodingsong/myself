package com.example.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Editor;
import com.example.enumeration.SexEnum;
import com.example.model.vo.user.UserDO;
import com.example.model.vo.user.UserVO2;
import com.example.util.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@Slf4j
@RestController
@RequestMapping("/test2")
public class Test2Controller {


    public static void main(String[] args) throws InterruptedException {

        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 20, 2));
        List<UserVO2> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO2::new);
//        log.info("userVOList:{}",userVOList);
//



//        List<UserVO2> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO2::new, (userDO, userVO) ->{
//            // 这里可以定义特定的转换规则
//            userVO.setSex(SexEnum.getDescByCode(userDO.getSex()).getDesc());
//        });
        log.info("userVOList:{}",userVOList);
        // ==============================================================
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("3");
        list2.add("7");
        list2.add("8");

        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);

        // ==============================================================




        Map<String, Object> m = new HashMap<String, Object>() {{
            put("k1", "v1");
            put("k2", "v2");
            put("k3", "v3");
        }};

        String[] inc = {"k1", "k3"};//需要的key
        List<String> incList = Arrays.asList(inc);


        m = CollectionUtil.filter(m, (Editor<Map.Entry<String, Object>>) stringObjectEntry -> {
            if (incList.contains(stringObjectEntry.getKey())) {
                return stringObjectEntry;
            }
            return null;
        });
        log.info("{}", m);

        // 减法计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"GO OUT");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("Close Door");

        // 加法计数器
       //  信号量
        // 线程数量 ： 停车位 限流 S
         Semaphore semaphore = new Semaphore(3);
         for (int r = 0; r <6 ; r++) {
             // semaphore.acquire(); 获得
              new Thread(()->{
                  try {
                      semaphore.acquire();
                      System.out.println(Thread.currentThread().getName()+"获得车位");
                      TimeUnit.SECONDS.sleep(2);
                      System.out.println(Thread.currentThread().getName()+"离开车位");
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }finally {
                      semaphore.release();
                        } }).start();
         }
    }

}
