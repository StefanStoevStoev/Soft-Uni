package com.example.irrigation2.util;

import com.example.irrigation2.model.entity.RoleEntity;
import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.repository.UserRepository;
import com.example.irrigation2.repository.UserRoleRepository;
import org.springframework.stereotype.Component;

@Component
public class TestDataUtils {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public TestDataUtils(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    private void initRoles(){
        RoleEntity adminRole = new RoleEntity().setRole(RoleEnum.ADMIN);
        RoleEntity userRole = new RoleEntity().setRole(RoleEnum.USER);

        userRoleRepository.save(adminRole);
        userRoleRepository.save(userRole);
    }

    public UserEntity createTestUser(String email){
        initRoles();

        UserEntity user = new UserEntity()
                .setActive(true)
                .setEmail(email)
                .setFirstName("User")
                .setLastName("Userov")
                .setRole(userRoleRepository.findAll());
        return userRepository.save(user);
    }

    public void cleanUpDatabase(){
        userRepository.deleteAll();
    }
}
