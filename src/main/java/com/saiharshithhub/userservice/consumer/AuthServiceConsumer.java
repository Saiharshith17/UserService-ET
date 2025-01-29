package com.saiharshithhub.userservice.consumer;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import com.saiharshithhub.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceConsumer {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;  // Redis for distributed locking

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData) {
        String lockKey = "userLock:" + eventData.getEmail(); // Unique lock per user
        ValueOperations<String, String> ops = redisTemplate.opsForValue();

        boolean isLocked = ops.setIfAbsent(lockKey, "LOCKED", 10, TimeUnit.SECONDS); // 10s lock

        if (!isLocked) {
            System.out.println("Duplicate event detected. Skipping processing for: " + eventData.getEmail());
            return;
        }

        try {
            userService.createOrUpdateUser(eventData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redisTemplate.delete(lockKey); // Release lock
        }
    }
}
