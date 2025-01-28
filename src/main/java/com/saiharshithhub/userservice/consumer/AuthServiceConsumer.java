package com.saiharshithhub.userservice.consumer;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import com.saiharshithhub.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceConsumer {

    @Autowired
    private UserService userService;





    @KafkaListener(topics="${spring.kafka.topic-json.name}",groupId="${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try{
             userService.createOrUpdateUser(eventData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
