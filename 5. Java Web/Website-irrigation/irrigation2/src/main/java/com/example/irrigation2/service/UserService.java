package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.DTO.*;
import com.example.irrigation2.model.entity.PumpNumbers;
import com.example.irrigation2.model.entity.RoleEntity;
import com.example.irrigation2.model.entity.SprinklerEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.model.mapper.AuthModelDTO;
import com.example.irrigation2.model.mapper.UserMapper;
import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.repository.SprinklerRepository;
import com.example.irrigation2.repository.UserRepository;
import com.example.irrigation2.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final UserMapper userMapper;
    private final AuthModelDTO authModelDTO;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService1,
                       UserMapper userMapper,
                       AuthModelDTO authModelDTO) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService1;
        this.userMapper = userMapper;
        this.authModelDTO = authModelDTO;
    }

    public void init() {

        if (userRepository.count() == 0 && userRoleRepository.count() == 0) {
            RoleEntity adminRole = new RoleEntity().setRole(RoleEnum.ADMIN);
            RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);
            userRole = this.userRoleRepository.save(userRole);

            adminRole = this.userRoleRepository.save(adminRole);

            initAdmin(List.of(adminRole));
            initUser(List.of(userRole));
//            initUser2(List.of(userRole));
        }
    }

    private void initAdmin(List<RoleEntity> roles) {
        UserEntity admin = new UserEntity()
                .setRole(roles)
                .setFirstName("Stefan")
                .setLastName("Stoev")
                .setEmail("stoev.stefan@gmail.com")
                .setPhone("0859224538")
                .setAddress("кв. Раковски, бл. 64, вх. Б, ап. 43")
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
//    private void initUser2(List<RoleEntity> roles) {
//
//        UserEntity user2 = new UserEntity()
//                .setRole(roles)
//                .setFirstName("Gosho")
//                .setLastName("Georgiev")
//                .setEmail("gosho@gmail.com")
//                .setPassword(passwordEncoder.encode("123"));
//
//        userRepository.save(user2);
//    }

    public boolean registerAndLogin(UserRegisterDTO userRegisterDTO) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }
        UserEntity byEmail = userRepository.findByEmail(userRegisterDTO.getEmail()).orElse(null);
        if (byEmail != null) {
            return false;
        }
        RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);
        userRole = this.userRoleRepository.save(userRole);

        UserEntity userEntity = userMapper.userDtoToUserEntity(userRegisterDTO)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        userEntity.getRole().add(userRole);
        this.userRepository.save(userEntity);
        login(userEntity);

//        emailService.sendRegistrationEmail(userEntity.getEmail(),
//                userEntity.getFirstName() + " " + userEntity.getLastName(), preferredLocale);
        return true;
    }

    private void login(UserEntity userEntity) {
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication auth =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );
        SecurityContextHolder.
                getContext().
                setAuthentication(auth);
    }

    public boolean exists(String username) {
        return this.userRepository.existsByUsername(username);
    }

    public boolean isPasswordValid(String username, String givenPassword) {
        String validPassword = this.userRepository.findPassword(username);
        String encodedGivenPass = this.passwordEncoder.encode(givenPassword);
        return validPassword.equals(encodedGivenPass);
    }

    public UserViewModel getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);

        UserViewModel userViewModel = new UserViewModel();

        assert user != null;
        return userViewModel
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setAuthority(user.getAuthority())
                .setPhone(user.getPhone())
                .setAddress(user.getAddress());
    }

    //AuthController
    public void saveDataToUser(AuthDTO authDTO, CurrentUserDetails currentUser) {
        UserEntity userData = authModelDTO.authDetailsUserEntity(authDTO);
        UserEntity user = userRepository.findByEmail(currentUser.getEmail()).orElse(null);

        assert user != null;
        user.setPhone(userData.getPhone())
                .setAddress(userData.getAddress())
                .setFirstName(userData.getFirstName())
                .setLastName(userData.getLastName());
        userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
//        List<UserEntity> usersByDrips = userRepository.getAllOrderByUsersDripDesc();
//        List<UserEntity> usersByPumps = userRepository.getAllOrderByUsersPumpDesc();
//        List<UserEntity> usersBySprinklers = userRepository.getAllOrderByUsersSprinklerDesc();
//        int size = usersBySprinklers.size();
//        int size1 = usersByPumps.size();
//        int size2 = usersByDrips.size();
//
//        List<UserEntity> users = new ArrayList<>();
//        if(size2 > size1){
//            users = usersByDrips;
//        } else if(size1 > size) {
//            users = usersByPumps;
//        } else {
//            users = usersBySprinklers;
//        }

        return userRepository.findAll();
    }

}





































