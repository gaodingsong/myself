package com.example.lock;

public abstract class AbstractDistributedLock implements DistributedLock {

    @Override
    public abstract boolean lock(String key, int expires, int retries, long sleep);

    @Override
    public boolean lock(String key, int expires, int retries) {
        return lock(key, expires, retries, SLEEP);
    }

    @Override
    public boolean lock(String key, int expires) {
        return lock(key, expires, RETRIES);
    }

    @Override
    public boolean lock(String key) {
        return lock(key, TIME_OUT);
    }
}
