package com.xub.sprinboot.study.redis.utils;

import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-20
 */
public class RedisUtil {

    private final StringRedisTemplate redisTemplate;
    private final ValueOperations<String, String> valueOperations;
    private final HashOperations<String, String, String> hashOperations;
    private final ListOperations<String, String> listOperations;
    private final SetOperations<String, String> setOperations;
    private final ZSetOperations<String, String> zSetOperations;

    public RedisUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        valueOperations = redisTemplate.opsForValue();
        hashOperations = redisTemplate.opsForHash();
        listOperations = redisTemplate.opsForList();
        setOperations = redisTemplate.opsForSet();
        zSetOperations = redisTemplate.opsForZSet();
    }

    //------------------------------------------------------------------------------------------------------KV 操作------------------------------------------------------------------------------------------------------

    /**
     * Redis SET 命令用于将键 key 设定为指定的“字符串”值。
     *
     * 如果 key 已经保存了一个值，那么这个操作会直接覆盖原来的值，并且忽略原始类型。
     *
     * 当 set 命令执行成功之后，之前设置的过期时间都将失效
     *
     * 选项
     * 从2.6.12版本开始，redis为SET命令增加了一系列选项:
     *
     * EX seconds – 设置键key的过期时间，单位时秒
     * PX milliseconds – 设置键key的过期时间，单位时毫秒
     * NX – 只有键key不存在的时候才会设置key的值
     * XX – 只有键key存在的时候才会设置key的值
     * KEEPTTL -- 获取 key 的过期时间
     * GET -- 返回 key 存储的值，如果 key 不存在返回空
     * 注意: 由于SET命令加上选项已经可以完全取代SETNX, SETEX, PSETEX, GETSET,的功能，所以在将来的版本中，redis可能会不推荐使用并且最终抛弃这几个命令。
     *
     * 返回值
     * 字符串: 如果SET命令正常执行那么回返回OK 多行字符串: 使用 GET 选项，返回 key 存储的值，如果 key 不存在返回空 空: 否则如果加了NX 或者 XX选项，SET 没执行，那么会返回nil。
     *
     * 历史
     * >= 2.6.12: Added the EX, PX, NX and XX options.
     * >= 6.0: Added the KEEPTTL option.
     * >= 6.2: Added the GET option.
     * @param key
     * @param value
     */
    public void setValue(String key, String value) {
        valueOperations.set(key, value);
    }

    /**
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        valueOperations.set(key, value, timeout, timeUnit);
    }

    /**
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return valueOperations.get(key);
    }

    /**
     * 将键 key 的值设为 value ， 并返回键 key 在被设置之前的旧值。
     *
     * 返回给定键 key 的旧值。
     *
     * 如果键 key 没有旧值， 也即是说， 键 key 在被设置之前并不存在， 那么命令返回 nil 。
     *
     * 当键 key 存在但不是字符串类型时， 命令返回一个错误
     * @param key
     * @param value
     * @return
     */
    public String setAndGetOldValue(String key, String value) {
        return valueOperations.getAndSet(key, value);
    }

    /**
     * 命令在指定的 key 不存在时，为 key 设置指定的值，这种情况下等同 SET 命令。当 key存在时，什么也不做
     * @param key
     * @param value
     * @return
     */
    public Boolean setIfAbsent(String key, String value) {
        return valueOperations.setIfAbsent(key, value);
    }

    /**
     * 命令在指定的 key 不存在时，为 key 设置指定的值，这种情况下等同 SET 命令。当 key存在时，什么也不做
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     * @return
     */
    public Boolean setIfAbsent(String key, String value, long timeout, TimeUnit timeUnit) {
        return valueOperations.setIfAbsent(key, value, timeout, timeUnit);
    }

    /**
     * 命令在指定的 key 存在时，为 key 设置指定的值，这种情况下等同 SET 命令。当 key不存在时，什么也不做
     * 该方法在你使用管道或者事务时就会返回null。 null when used in pipeline or transaction
     * @param key
     * @param value
     * @return
     */
    public Boolean setIfPresent(String key, String value) {
        return valueOperations.setIfPresent(key, value);
    }

    /**
     * 命令在指定的 key 存在时，为 key 设置指定的值，这种情况下等同 SET 命令。当 key不存在时，什么也不做
     * 该方法在你使用管道或者事务时就会返回null。 null when used in pipeline or transaction
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     * @return
     */
    public Boolean setIfPresent(String key, String value, long timeout, TimeUnit timeUnit) {
        return valueOperations.setIfPresent(key, value, timeout, timeUnit);
    }


    //批量操作
    public void mSetValue(Map<String, String> values) {
        valueOperations.multiSet(values);
    }

    public List<String> mSetValue(List<String> keys) {
        return valueOperations.multiGet(keys);
    }

    public List<String> mGetValue(List<String> keys) {
        return valueOperations.multiGet(keys);
    }

    /**
     * 实现计数的加（ value为负数表示减）
     *
     * @param key
     * @param value
     * @return 返回redis中的值
     */
    public Long incr(String key, long value) {
        return valueOperations.increment(key, value);
    }

    /**
     * 实现计数的减（ value为负数表示减）
     *
     * @param key
     * @param value
     * @return
     */
    public Long decr(String key, long value) {
        return valueOperations.decrement(key, value);
    }


    // bitmap的测试相关

    public Boolean setBit(String key, Integer index, Boolean tag) {
        return redisTemplate.execute((RedisCallback<Boolean>) con -> con.setBit(key.getBytes(), index, tag));
    }

    public Boolean getBit(String key, Integer index) {
        return redisTemplate.execute((RedisCallback<Boolean>) con -> con.getBit(key.getBytes(), index));
    }

    /**
     * 统计bitmap中，value为1的个数，非常适用于统计网站的每日活跃用户数等类似的场景
     *
     * @param key
     * @return
     */
    public Long bitCount(String key) {
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes()));
    }

    public Long bitCount(String key, int start, int end) {
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes(), start, end));
    }

    public Long bitOp(RedisStringCommands.BitOperation op, String saveKey, String... desKey) {
        byte[][] bytes = new byte[desKey.length][];
        for (int i = 0; i < desKey.length; i++) {
            bytes[i] = desKey[i].getBytes();
        }
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitOp(op, saveKey.getBytes(), bytes));
    }
}
