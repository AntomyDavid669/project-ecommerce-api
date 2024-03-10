package com.project.ecommerceAPI.service.impl;

import com.project.ecommerceAPI.dto.UserDto;
import com.project.ecommerceAPI.entities.RoleEntity;
import com.project.ecommerceAPI.entities.UserEntity;
import com.project.ecommerceAPI.repository.RoleRepository;
import com.project.ecommerceAPI.repository.UserRepository;
import com.project.ecommerceAPI.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNamaLengkap(userDto.getNamaLengkap());
        userEntity.setUsername(userDto.getUsername());
        //encrypt the password using spring security
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        RoleEntity roleEntity = roleRepository.findByName("ROLE_ADMIN");
        if(roleEntity == null){
            roleEntity = checkRoleExist();
        }
        userEntity.setRoles(List.of(roleEntity));
        userRepository.save(userEntity);
    }

    private RoleEntity checkRoleExist() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_ADMIN");
        return roleRepository.save(roleEntity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userEntity -> convertEntityToDto(userEntity))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setNamaLengkap(userEntity.getNamaLengkap());
        userDto.setUsername(userEntity.getUsername());
        return userDto;
    }
}
