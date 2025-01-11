package com.saiharshithhub.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserInfoDto {
    Long id;

    @Id
    private String userId;

    private String firstName;// first_name is snakecase so we need to map them to camelcase (firstName)

    private String lastName;

    private Long phoneNumber;

    private String email;

    private String profilePic;
}
