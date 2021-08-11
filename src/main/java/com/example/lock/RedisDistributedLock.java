package com.example.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisDistributedLock extends AbstractDistributedLock {

    private RedisTemplate<String, Object> redisTemplate;

    private ThreadLocal<String> tl = new ThreadLocal<>();

    public RedisDistributedLock(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private static String UNLOCK_LUA = "if redis.call(\"get\",KEYS[1]) == ARGV[1]" +
            "then" +
            "    return redis.call(\"del\",KEYS[1])" +
            "else" +
            "    return 0 " +
            "end";

    @Override
    public boolean lock(String key, int expires, int retries, long sleep) {
        boolean result = setRedis(key, expires);
        while ((!result) && retries-- > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                log.error("InterruptedException", e);
                Thread.currentThread().interrupt();
            }
            result = setRedis(key, expires);
        }
        return result;
    }

    private boolean setRedis(String key, int expires) {
        Boolean result = null;
        try {
            result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                String uuid = UUID.randomUUID().toString();
                tl.set(uuid);
                byte[] keys = redisTemplate.getStringSerializer().serialize(key);
                byte[] vals = redisTemplate.getStringSerializer().serialize(uuid);
                //setNx
                //key存在不更新，不存在新增
                return connection.set(keys, vals, Expiration.from(expires, TimeUnit.MILLISECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);
            });
        } catch (Exception e) {
            log.error("redis distributedLock lock happened a exception", e);
        }
        return result;
    }

    @Override
    public boolean unlock(String key) {
        // 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
        try {
            // 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
            Boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                byte[] scripts = redisTemplate.getStringSerializer().serialize(UNLOCK_LUA);
                byte[] keys = redisTemplate.getStringSerializer().serialize(key);
                byte[] vals = redisTemplate.getStringSerializer().serialize(tl.get());
                return connection.eval(scripts, ReturnType.BOOLEAN, 1, keys, vals);
            });
            return result;
        } catch (Exception e) {
            log.error("redis distributedLock unlock happened a exception", e);
        }
        return false;
    }
}
