package com.example.lock.sync;

import org.openjdk.jol.info.ClassLayout;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/2/18 10:03 上午
 * @version:1.0
 */
public class Demo implements Runnable{


    int count = 0;
    static LubanLock lubanLock = new LubanLock();
    ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        synchronized (lubanLock){
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.lock();
            count++;
        }
    }

    public static void main(String[] args) {
        new Thread(new Demo(),"thread1").start();
        System.out.println(ClassLayout.parseInstance(lubanLock).toPrintable());


    }
}
