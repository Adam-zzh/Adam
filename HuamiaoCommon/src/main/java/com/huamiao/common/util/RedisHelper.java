package com.huamiao.common.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈redis辅助工具〉
 *
 * @author ZZH
 * @create 2023/5/8
 * @since 1.0.0
 */
public class RedisHelper {

    private RedisTemplate<String, Object> getRedisTemplate(){
        return ApplicationUtil.getBean(RedisTemplate.class);
    }
    
    public void set(String key, Object value, long time) {
        getRedisTemplate().opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    
    public void set(String key, Object value) {
        getRedisTemplate().opsForValue().set(key, value);
    }

    
    public Object get(String key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    
    public Boolean del(String key) {
        return getRedisTemplate().delete(key);
    }

    
    public Long del(List<String> keys) {
        return getRedisTemplate().delete(keys);
    }

    
    public Boolean expire(String key, long time) {
        return getRedisTemplate().expire(key, time, TimeUnit.SECONDS);
    }

    
    public Long getExpire(String key) {
        return getRedisTemplate().getExpire(key, TimeUnit.SECONDS);
    }

    
    public Boolean hasKey(String key) {
        return getRedisTemplate().hasKey(key);
    }

    
    public Long incr(String key, long delta) {
        return getRedisTemplate().opsForValue().increment(key, delta);
    }

    
    public Long decr(String key, long delta) {
        return getRedisTemplate().opsForValue().increment(key, -delta);
    }

    
    public Object hGet(String key, String hashKey) {
        return getRedisTemplate().opsForHash().get(key, hashKey);
    }

    
    public Boolean hSet(String key, String hashKey, Object value, long time) {
        getRedisTemplate().opsForHash().put(key, hashKey, value);
        return expire(key, time);
    }

    
    public void hSet(String key, String hashKey, Object value) {
        getRedisTemplate().opsForHash().put(key, hashKey, value);
    }

    
    public Map<Object, Object> hGetAll(String key) {
        return getRedisTemplate().opsForHash().entries(key);
    }

    
    public Boolean hSetAll(String key, Map<String, Object> map, long time) {
        getRedisTemplate().opsForHash().putAll(key, map);
        return expire(key, time);
    }

    
    public void hSetAll(String key, Map<String, ?> map) {
        getRedisTemplate().opsForHash().putAll(key, map);
    }

    
    public void hDel(String key, Object... hashKey) {
        getRedisTemplate().opsForHash().delete(key, hashKey);
    }

    
    public Boolean hHasKey(String key, String hashKey) {
        return getRedisTemplate().opsForHash().hasKey(key, hashKey);
    }

    
    public Long hIncr(String key, String hashKey, Long delta) {
        return getRedisTemplate().opsForHash().increment(key, hashKey, delta);
    }

    
    public Long hDecr(String key, String hashKey, Long delta) {
        return getRedisTemplate().opsForHash().increment(key, hashKey, -delta);
    }

    
    public Set<Object> sMembers(String key) {
        return getRedisTemplate().opsForSet().members(key);
    }

    
    public Long sAdd(String key, Object... values) {
        return getRedisTemplate().opsForSet().add(key, values);
    }

    
    public Long sAdd(String key, long time, Object... values) {
        Long count = getRedisTemplate().opsForSet().add(key, values);
        expire(key, time);
        return count;
    }

    
    public Boolean sIsMember(String key, Object value) {
        return getRedisTemplate().opsForSet().isMember(key, value);
    }

    
    public Long sSize(String key) {
        return getRedisTemplate().opsForSet().size(key);
    }

    
    public Long sRemove(String key, Object... values) {
        return getRedisTemplate().opsForSet().remove(key, values);
    }

    
    public List<Object> lRange(String key, long start, long end) {
        return getRedisTemplate().opsForList().range(key, start, end);
    }

    
    public Long lSize(String key) {
        return getRedisTemplate().opsForList().size(key);
    }

    
    public Object lIndex(String key, long index) {
        return getRedisTemplate().opsForList().index(key, index);
    }

    
    public Long lPush(String key, Object value) {
        return getRedisTemplate().opsForList().rightPush(key, value);
    }

    
    public Long lPush(String key, Object value, long time) {
        Long index = getRedisTemplate().opsForList().rightPush(key, value);
        expire(key, time);
        return index;
    }

    
    public Long lPushAll(String key, Object... values) {
        return getRedisTemplate().opsForList().rightPushAll(key, values);
    }

    
    public Long lPushAll(String key, Long time, Object... values) {
        Long count = getRedisTemplate().opsForList().rightPushAll(key, values);
        expire(key, time);
        return count;
    }

    
    public Long lRemove(String key, long count, Object value) {
        return getRedisTemplate().opsForList().remove(key, count, value);
    }
}