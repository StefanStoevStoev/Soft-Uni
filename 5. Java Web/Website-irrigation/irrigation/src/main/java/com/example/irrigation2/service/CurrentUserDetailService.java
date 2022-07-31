package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.entity.RoleEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class CurrentUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CurrentUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByEmail(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email "
                        + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new CurrentUserDetails(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.
                        getRole().
                        stream().
                        map(this::map).
                        collect(Collectors.toList())
        );
    }
    private GrantedAuthority map(RoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.
                        getRole().name());
    }
}
