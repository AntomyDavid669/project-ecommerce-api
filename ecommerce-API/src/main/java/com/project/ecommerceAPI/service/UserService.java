package com.project.ecommerceAPI.service;

import com.project.ecommerceAPI.dto.UserDto;
import com.project.ecommerceAPI.entities.UserEntity;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    UserEntity findByUsername(String username);

    List<UserDto> findAllUser();
}
