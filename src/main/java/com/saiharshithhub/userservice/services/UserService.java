package com.saiharshithhub.userservice.services;

import com.saiharshithhub.userservice.entities.UserInfo;
import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional  // Ensures atomicity
    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto) {
        UnaryOperator<UserInfo> updatingUser = user -> {
            user.setFirstName(userInfoDto.getFirstName());
            user.setLastName(userInfoDto.getLastName());
            user.setPhoneNumber(userInfoDto.getPhoneNumber());
            user.setEmail(userInfoDto.getEmail());
            user.setProfilePic(userInfoDto.getProfilePic());
            return userRepository.save(user);
        };

        Supplier<UserInfo> createUser = () -> userRepository.save(userInfoDto.transformToUserInfo());

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }

    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception {
        return userRepository.findByUserId(userInfoDto.getUserId())
                .map(user -> new UserInfoDto(
                        user.getUserId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPhoneNumber(),
                        user.getEmail(),
                        user.getProfilePic()
                ))
                .orElseThrow(() -> new Exception("User Not Found"));
    }
}
