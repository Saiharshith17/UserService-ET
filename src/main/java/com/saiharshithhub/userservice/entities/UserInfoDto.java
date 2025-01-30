package com.saiharshithhub.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {




    @JsonProperty("user_id")
    @Column(nullable = false, unique = true)
    private String userId;

    @JsonProperty("first_name")
    @Column(nullable = false, unique = true)
    private String firstName;// first_name is snakecase so we need to map them to camelcase (firstName)

    @JsonProperty("last_name")
    @Column(nullable = false, unique = true)
    private String lastName;

    @JsonProperty("phone_number")
    @Column(nullable = false, unique = true)
    private Long phoneNumber;

    @JsonProperty("email")
    @Column(nullable = false, unique = true)
    private String email;
    @JsonProperty("profile_pic")
    @Column(nullable = false, unique = true)
    private String profilePic;

    public UserInfo  transformToUserInfo(){
       return UserInfo.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(phoneNumber).profilePic(profilePic).build();
    }
}
