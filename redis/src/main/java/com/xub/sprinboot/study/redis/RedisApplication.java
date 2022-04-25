package com.xub.sprinboot.study.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class RedisApplication {

    public RedisApplication(RedisTemplate<String, String> redisTemplate) {
        redisTemplate.opsForValue().get("key");

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        while (true) {
            executorService.submit(() -> {
                redisTemplate.opsForValue().get("test");
            });
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
