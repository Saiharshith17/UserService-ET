package com.saiharshithhub.userservice.consumer;

import com.saiharshithhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class AuthServiceConsumer {
    private UserRepository userRepository;
    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @KafkaListener(topics="${spring.kafka.topic-json.name}",groupId="${spring.kafka.consumer.group-id}")
    public void listen(Object eventData){
        try{

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
