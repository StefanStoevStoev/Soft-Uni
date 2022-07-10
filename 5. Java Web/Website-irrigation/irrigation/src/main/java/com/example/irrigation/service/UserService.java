package com.example.irrigation.service;

import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.model.entity.RoleEntity;
import com.example.irrigation.model.entity.UserEntity;
import com.example.irrigation.model.entity.enums.RoleEnum;
import com.example.irrigation.repository.UserRepository;
import com.example.irrigation.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService1) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService1;
    }

    public void init() {

        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {
            RoleEntity adminRole = new RoleEntity().setRole(RoleEnum.ADMIN);
            RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);

            adminRole = this.userRoleRepository.save(adminRole);
            userRole = this.userRoleRepository.save(userRole);

            initAdmin(List.of(adminRole));
            initUser(List.of(userRole));
        }
    }

    private void initAdmin(List<RoleEntity> roles) {
        UserEntity admin = new UserEntity()
                .setRole(roles)
                .setFirstName("Stefan")
                .setLastName("Stoev")
                .setEmail("stoev.stefan@gmail.com")
                .setPassword(passwordEncoder.encode("123"));
        userRepository.save(admin);
    }

    private void initUser(List<RoleEntity> roles) {

        UserEntity user = new UserEntity()
                .setRole(roles)
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setPassword(passwordEncoder.encode("123"));

        userRepository.save(user);
    }

//    public boolean login(UserLoginDTO userLoginDTO){
//
//        Optional<UserEntity> byEmail = userRepository.findByEmail(userLoginDTO.getEmail());
//        if (byEmail.isPresent()) {
//            return false;
//        }
//        UserEntity userEntity = new UserEntity()
//                .setEmail(userLoginDTO.getEmail())
//                .setPassword(passwordEncoder.encode(userLoginDTO.getPassword()));
//
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());
//
//        Authentication auth = new UsernamePasswordAuthenticationToken(
//                userDetails,
//                userDetails.getPassword(),
//                userDetails.getAuthorities()
//        );
//
//        SecurityContextHolder
//                .getContext()
//                .setAuthentication(auth);
//
//        return true;
//    }

    public boolean registerAndLogin(UserRegisterDTO userRegisterDTO) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }
        Optional<UserEntity> byEmail = userRepository.findByEmail(userRegisterDTO.getEmail());
        if (byEmail.isPresent()) {
            return false;
        }

        UserEntity userEntity = new UserEntity()
                .setEmail(userRegisterDTO.getEmail())
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userRepository.save(userEntity);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder
                .getContext()
                .setAuthentication(auth);

        return true;
    }
}





































