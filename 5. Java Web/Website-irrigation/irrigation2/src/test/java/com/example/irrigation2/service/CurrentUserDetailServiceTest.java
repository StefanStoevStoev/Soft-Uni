package com.example.irrigation2.service;

import com.example.irrigation2.model.CurrentUserDetails;
import com.example.irrigation2.model.entity.RoleEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentUserDetailServiceTest {

    @Mock
    private UserRepository mockUserRepo;
    private CurrentUserDetailService toTest;

    @BeforeEach
    void setUp() {
        toTest = new CurrentUserDetailService(
                mockUserRepo
        );
    }

    @Test
    void testLoadUserByUsername_UserExists() {
//arrange
        UserEntity testUserEntity = new UserEntity()
                .setEmail("ffs@mail.bg")
                .setFirstName("Pesho")
                .setLastName("Petrov")
                .setPassword("123")
                .setActive(true)
                .setRole(List.of(
                        new RoleEntity().setRole(RoleEnum.ADMIN),
                        new RoleEntity().setRole(RoleEnum.USER)));
        when(mockUserRepo.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));
//act
        CurrentUserDetails userDetails = (CurrentUserDetails)
        toTest.loadUserByUsername(testUserEntity.getEmail());
//        assert

        Assertions.assertEquals(testUserEntity.getFirstName() + " " +testUserEntity.getLastName() ,userDetails.getUsername());

        Assertions.assertEquals(testUserEntity.getFirstName() + " " +testUserEntity.getLastName(), userDetails.getFullName());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        Assertions.assertEquals(2, authorities.size());

        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        Assertions.assertEquals("ROLE_" + RoleEnum.ADMIN.name(), iterator.next().getAuthority());
        Assertions.assertEquals("ROLE_" + RoleEnum.USER.name(), iterator.next().getAuthority());
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExists() {

        Assertions.assertThrows(
                UsernameNotFoundException.class, ()-> toTest.loadUserByUsername("not-exist@example.com")
        );
    }
}
