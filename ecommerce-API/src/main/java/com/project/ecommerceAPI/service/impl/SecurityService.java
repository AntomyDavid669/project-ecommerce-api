package com.project.ecommerceAPI.service.impl;

import com.project.ecommerceAPI.entities.RoleEntity;
import com.project.ecommerceAPI.entities.UserEntity;
import com.project.ecommerceAPI.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityService implements UserDetailsService {
    private UserRepository userRepository;

    public SecurityService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(username);

        if(userEntity != null){
            return new org.springframework.security.core.userdetails.User(userEntity.getUsername(),
                    userEntity.getPassword(),
                    mapRolesToAuthorities(userEntity.getRoles()));
        }else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<RoleEntity> roleEntities) {
        Collection<? extends GrantedAuthority> mapRoles = roleEntities.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
