package com.saiharshithhub.userservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class UserInfo {
    @Transient  //change in this part is taken and dont know that could effect the connection issue
    private Long id;

    @Id
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
    private String profilePic;
}
