package com.example.controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/6 16:20
 * @version:1.0
 */
public class QueueController {

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
//        test3();
        test4();
    }

    /** * 跑出异常 */
    public static void test1(){
        // 指定队列大小后 如果超出则报异常 Queue full
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("A"));
        System.out.println(blockingQueue.add("B"));
//        System.out.println(blockingQueue.add("C"));
//        System.out.println(blockingQueue.add("D"));

        System.out.println(blockingQueue.element());// 获取队首元素

        // 如果队列里面没有元素 继续移除则报NoSuchElementException


        System.out.println("blockingQueue.remove()");
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }



    /** * 有返回值 没有异常 */
    public static void test2(){
        // 指定队列大小后
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("A"));
        System.out.println(blockingQueue.offer("B"));
        System.out.println(blockingQueue.offer("C"));
        System.out.println(blockingQueue.offer("D"));// 超出队列指定大小之后 若继续添加则返回false 不跑出异常

        System.out.println(blockingQueue.peek());// 获取队首元素

// 如果队列里面没有元素 继续移除则报NoSuchElementException
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());// 若队列中没有元素了 还继续取 返回null


    }
    /** * 等待 阻塞 一直等待 */
    public static void test3() throws InterruptedException {
        // 指定队列大小后
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("A");
        blockingQueue.put("B");
        blockingQueue.put("C");


//         blockingQueue.put("D");// 队列没有位置了 会一直阻塞
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());// 若队列没值了 继续取 会一直阻塞

    }

    /** * 等待 阻塞 等待超时 */
    public static void test4() throws InterruptedException {
        // 指定队列大小后
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("A");
        blockingQueue.offer("B");
        blockingQueue.offer("C");

         blockingQueue.offer("D",2,TimeUnit.SECONDS); // 等待 超过2s 就退出

        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();

        blockingQueue.poll(2, TimeUnit.SECONDS); // 等待 超过2s 就退出


    }
}
