package com.saiharshithhub.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserInfoDto {




    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("first_name")
    private String firstName;// first_name is snakecase so we need to map them to camelcase (firstName)
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("phone_number")
    private Long phoneNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("profile_pic")
    private String profilePic;

    public UserInfo  transformToUserInfo(){
       return UserInfo.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).profilePic(profilePic).build();
    }
}
