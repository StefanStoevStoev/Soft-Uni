package com.example.irrigation.service;

import com.example.irrigation.model.CurrentUserDetails;
import com.example.irrigation.model.DTO.AuthDTO;
import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.model.entity.RoleEntity;
import com.example.irrigation.model.entity.UserEntity;
import com.example.irrigation.model.entity.enums.RoleEnum;
import com.example.irrigation.model.mapper.AuthModelDTO;
import com.example.irrigation.model.mapper.UserDetailsMapper;
import com.example.irrigation.model.mapper.UserMapper;
import com.example.irrigation.model.views.UserViewModel;
import com.example.irrigation.repository.UserRepository;
import com.example.irrigation.repository.UserRoleRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService{

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final UserMapper userMapper;
    private final EmailService emailService;
    private final UserDetailsMapper userDetailsMapper;
    private final AuthModelDTO authModelDTO;

    public UserService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       UserDetailsService userDetailsService1,
                       UserMapper userMapper,
                       EmailService emailService,
                       UserDetailsMapper userDetailsMapper, AuthModelDTO authModelDTO) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService1;
        this.userMapper = userMapper;
        this.emailService = emailService;
        this.userDetailsMapper = userDetailsMapper;
        this.authModelDTO = authModelDTO;
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

    public boolean registerAndLogin(UserRegisterDTO userRegisterDTO, Locale preferredLocale) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }
        UserEntity byEmail = userRepository.findByEmail(userRegisterDTO.getEmail()).orElse(null);
        if (byEmail == null) {
            return false;
        }

        UserEntity userEntity = userMapper.userDtoToUserEntity(userRegisterDTO)
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(userEntity);
        login(userEntity);

        emailService.sendRegistrationEmail(userEntity.getEmail(),
                userEntity.getFirstName() + " " + userEntity.getLastName(), preferredLocale);
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

        assert user != null;
        UserViewModel userViewModel = new UserViewModel();

        return userViewModel
               .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setAuthority(user.getAuthority())
                .setPhone(user.getPhone())
                .setAddress(user.getAddress());
    }

    public void saveDataToUser(@Valid AuthDTO authDTO, CurrentUserDetails currentUser) {
        UserEntity userData = authModelDTO.authDetailsUserEntity(authDTO);
        UserEntity user = userRepository.findByEmail(currentUser.getEmail()).orElse(null);

        assert user != null;
        user.setPhone(userData.getPhone())
                .setAddress(userData.getAddress())
                .setFirstName(userData.getFirstName())
                .setLastName(userData.getLastName());
        userRepository.save(user);
    }

    public Optional<UserEntity> getById(long id) {
        return userRepository.findById(id);
    }

//    public UserEntity getCurrentlyLoggedInCustomer(Authentication authentication){
//        if(authentication == null){
//            return null;
//        }
//        UserEntity userEntity = null;
//        Object principal = authentication.getPrincipal();
//
//        if (principal instanceof CustomerUserDetails){
//            userEntity = ((CustomerUserDetails) principal);
//        } else if (principal instanceof CustomOAuth2User) {
//            String email = ((CustomOAuth2User) principal).getEmail();
//            userEntity = userRepository.findByEmail(email).orElse(null);
//        }
//        return userEntity;
//    }



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
}





































