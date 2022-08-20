package com.example.irrigation2.service;

import com.example.irrigation2.model.entity.BaseEntity;
import com.example.irrigation2.model.entity.DripEntity;
import com.example.irrigation2.model.entity.RoleEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.model.mapper.AuthModelDTO;
import com.example.irrigation2.model.mapper.UserMapper;
import com.example.irrigation2.model.views.UserViewModel;
import com.example.irrigation2.repository.UserRepository;
import com.example.irrigation2.repository.UserRoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private UserRoleRepository mockUserRoleRepository;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private UserDetailsService mockUserDetailsService;
    @Mock
    private UserMapper mockUserMapper;
    @Mock
    private AuthModelDTO mockAuthModelDTO;
    private UserService toTest;

    @BeforeEach
    void setUp(){
        toTest = new UserService(mockUserRepository,
                mockUserRoleRepository,
                mockPasswordEncoder,
                mockUserDetailsService,
                mockUserMapper,
                mockAuthModelDTO);
    }
    @Test
    void getAllUsers_userExists(){

        RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);
        UserEntity user = new UserEntity()
                .setRole(List.of(userRole))
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setPassword("123")
                .setAddress("Mladost N33")
                .setPhone("0859458235")
                .setActive(true);
        when(mockUserRepository.findAll()).thenReturn(List.of(user));

        List<UserEntity> getAllUsers = toTest.getAllUsers();

        Assertions.assertEquals(user.getRole(), getAllUsers.get(0).getRole());
        Assertions.assertEquals(user.getFirstName(), getAllUsers.get(0).getFirstName());
        Assertions.assertEquals(user.getEmail(), getAllUsers.get(0).getEmail());
        Assertions.assertEquals(user.getPassword(), getAllUsers.get(0).getPassword());
        Assertions.assertEquals(user.getPhone(), getAllUsers.get(0).getPhone());
        Assertions.assertEquals(user.getAddress(), getAllUsers.get(0).getAddress());
    }

    @Test
    void getUserById_userExists(){


        RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);
        UserEntity user = new UserEntity()

                .setRole(List.of(userRole))
                .setFirstName("Pesho")
                .setLastName("Peshev")
                .setEmail("pesho@gmail.com")
                .setPassword("123")
                .setAddress("Mladost N33")
                .setPhone("0859458235");

        UserEntity user1 = mockUserRepository.findById(user.getId()).orElse(null);
        when(user1).thenReturn(user);

        UserViewModel getUserById = toTest.getUserById(1L);

        Assertions.assertEquals(user.getAddress(), getUserById.getAddress());
        Assertions.assertEquals(user.getFirstName(), getUserById.getFirstName());
        Assertions.assertEquals(user.getEmail(), getUserById.getEmail());
        Assertions.assertEquals(user.getLastName(), getUserById.getLastName());
        Assertions.assertEquals(user.getId(), getUserById.getId());
    }
}
