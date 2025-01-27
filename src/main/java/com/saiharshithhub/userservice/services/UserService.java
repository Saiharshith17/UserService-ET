package com.saiharshithhub.userservice.services;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;
import java.util.function.Supplier;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        Function<UserInfo, UserInfo> updatingUser= user->{
            return userRepository.save(userInfoDto.transformToUserInfo());
        };
        Supplier<UserInfo> createUser=( )->{
            return userRepository.save(UserInfoDto.transformToUserInfo());
        };

        UserInfo userInfo=userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
    }

}
