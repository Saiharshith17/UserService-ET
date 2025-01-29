package com.saiharshithhub.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        return new StringRedisTemplate(new JedisConnectionFactory());
    }
}

