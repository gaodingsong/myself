package com.example.lock;

public interface DistributedLock {
    /**
     * 重试次数
     */
    int RETRIES = 100;
    /**
     * 锁超时时间
     */
    int TIME_OUT = 5000;
    /**
     * 获取失败重试等待时间
     */
    long SLEEP = 100;

    /**
     * @param key     持有锁信息
     * @param expires 锁超时时间
     * @param retries 重试
     * @param sleep   等待超时
     * @return
     */
    boolean lock(String key, int expires, int retries, long sleep);

    boolean lock(String key, int expires, int retries);

    boolean lock(String key, int expires);

    boolean lock(String key);

    boolean unlock(String key);
}