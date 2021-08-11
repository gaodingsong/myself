package com.example.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis分布式锁(第二種方式)
 *
 */
@Component
@Slf4j
public class RedisLock {

    public static final int LOCK_EXPIRE = 3000; // 默认锁3秒

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取锁（含锁时间）
     * @param key
     * @param expireTime 过期时间
     * @return
     */
    public Boolean lock(String key, int expireTime) {
        long expires = System.currentTimeMillis() + expireTime + 1;
        String expiresStr = String.valueOf(expires); // 锁到期时间

        try {
            if (redisTemplate.opsForValue().setIfAbsent(key, expiresStr)) {
                log.info("[1] 成功获取分布式锁!");
                return Boolean.TRUE;
            }

            String currentValueStr = redisTemplate.opsForValue().get(key);
            if(StringUtils.isNotBlank(currentValueStr) && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                String oldValue = redisTemplate.opsForValue().getAndSet(key, expiresStr);
                if(currentValueStr.equals(oldValue)) {
                    log.info("[2] 成功获取分布式锁!");
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

    /**
     * 获取锁（锁3秒释放）
     * @param key
     * @return
     */
    public Boolean lock(String key) {
        return lock(key, LOCK_EXPIRE);
    }

    /**
     * 释放锁
     * @param key
     */
    public void release(String key) {
        try {
            String currentValueStr = redisTemplate.opsForValue().get(key); // redis里的时间

            // 校验是否超过有效期, 如果不在有效期内, 那说明当前锁已经失效, 不能进行删除锁操作
            if (StringUtils.isNotBlank(currentValueStr) && Long.parseLong(currentValueStr) > System.currentTimeMillis()) {
                redisTemplate.delete(key);
                log.info("成功释放分布式锁!");
            }
        } finally {
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
    }

}
