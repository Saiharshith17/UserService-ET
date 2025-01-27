package com.saiharshithhub.userservice.consumer;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer {
    private UserRepository userRepository;
    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @KafkaListener(topics="${spring.kafka.topic-json.name}",groupId="${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try{
            UserInfo userInfo=eventData.transformToUserInfo();
            userRepository.save(userInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
