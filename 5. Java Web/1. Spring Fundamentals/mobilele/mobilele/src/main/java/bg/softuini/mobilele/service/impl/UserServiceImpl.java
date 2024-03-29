package bg.softuini.mobilele.service.impl;

import bg.softuini.mobilele.model.entities.UserEntity;
import bg.softuini.mobilele.model.entities.UserRoleEntity;
import bg.softuini.mobilele.model.entities.enums.UserRoleEnum;
import bg.softuini.mobilele.repository.UserRepository;
import bg.softuini.mobilele.security.CurrentUser;
import bg.softuini.mobilele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder
            , UserRepository userRepository
            , CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public boolean authenticate(String userName, String password) {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(userName);

        if (userEntityOptional.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(password, userEntityOptional.get().getPassword());
        }
    }

    @Override
    public void loginUser(String userName) {

        UserEntity user = userRepository.findByUsername(userName).orElseThrow();

        List<UserRoleEnum> userRoles = user
                .getUserRoles()
                .stream()
                .map(UserRoleEntity::getRole)
                .collect(Collectors.toList());

        currentUser.setAnonymous(false)
                .setName(user.getUsername())
                .setUserRoles(userRoles);
    }

    @Override
    public void logoutCurrentUser() {
        currentUser.setAnonymous(true);
    }

}
