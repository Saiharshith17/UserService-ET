package com.saiharshithhub.userservice.repository;

import com.saiharshithhub.userservice.entities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfoDto, String> {
    UserInfoDto findByUserId(String userId);
}
