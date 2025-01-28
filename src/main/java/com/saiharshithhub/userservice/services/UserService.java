package com.saiharshithhub.userservice.services;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser= user->{
            //todo :add the update logic
            return userRepository.save(user);
        };
        Supplier<UserInfo> createUser=( )->{
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo=userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser); //takes supplier and gives the same
        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()


        );


    }
    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{

        Optional<UserInfo> userInfoOpt=userRepository.findByUserId(userInfoDto.getUserId());
        if(userInfoOpt.isEmpty()){
            throw new Exception("User Not found");
        }
    }


}
