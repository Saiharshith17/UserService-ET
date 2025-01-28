package com.saiharshithhub.userservice.controller;


import com.saiharshithhub.userservice.entities.UserInfoDto;
import com.saiharshithhub.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/v1/createUpdate")
    public ResponseEntity<UserInfoDto> createUpdate(@RequestBody UserInfoDto userInfoDto){
        try{
            UserInfoDto user=userService.createOrUpdateUser(userInfoDto);
            return new ResponseEntity<>(user, HttpStatus.OK);

        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDto> getUser(UserInfoDto userInfoDto){
        try{
            UserInfoDto user=userService.getUser(userInfoDto);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(Exception ex){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
