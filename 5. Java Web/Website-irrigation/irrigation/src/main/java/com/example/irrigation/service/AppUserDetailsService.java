package com.example.irrigation.service;

import com.example.irrigation.model.entity.RoleEntity;
import com.example.irrigation.model.entity.UserEntity;
import com.example.irrigation.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;


//NOTE: This is not annotated as @Service because we will return it as a bean.

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        return userRepository
                .findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username "
                        + this.userRepository.findByEmail(email).get().getFirstName()
                        + " not found."));
    }

    private UserDetails map(UserEntity userEntity){//////////////////////?
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity
                        .getRole()
                        .stream()
                        .map(this::map).collect(Collectors.toList()))
                .build();
    }

    private GrantedAuthority map(RoleEntity roleEntity){
    return new SimpleGrantedAuthority("ROLE_" +
            roleEntity.getRole().name());
    }
}












