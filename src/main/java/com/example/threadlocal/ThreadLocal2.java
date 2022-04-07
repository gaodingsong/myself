package com.example.threadlocal;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/3/16 10:38 上午
 * @version:1.0
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> tl = new ThreadLocal<Person>();
    public static void main(String[] args) {


        tl.set(new Person());
//        System.out.println(tl.get());
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName());
//            tl.set(new Person());
//            System.out.println(tl.get());
//        }).start();
//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName());
//            tl.set(new Person());
//        }).start();


        System.out.println(Thread.currentThread().getName());
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());

    }

    static class Person{
        String name = UUID.randomUUID().toString();
    }
}
