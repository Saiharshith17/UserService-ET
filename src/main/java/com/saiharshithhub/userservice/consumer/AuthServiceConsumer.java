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





    public void listen(UserInfoDto eventData){
        try{
            //ToDo : Make it Transactional to handle idempotently and validate email,phonenumber  etc can use redis distributed lock
            userService.createOrUpdateUser(eventData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
