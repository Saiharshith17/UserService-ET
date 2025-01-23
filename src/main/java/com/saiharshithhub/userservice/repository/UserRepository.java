package com.saiharshithhub.userservice.repository;

import com.saiharshithhub.userservice.entities.UserInfoDto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends CrudRepository<UserInfoDto, String> {
    UserInfoDto findByUserId(String userId);
}
