package com.example.battleships.service;

import com.example.battleships.model.DTO.LoginDTO;
import com.example.battleships.model.DTO.RegisterDTO;
import com.example.battleships.model.entity.UserEntity;
import com.example.battleships.repository.UserRepository;
import com.example.battleships.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserService(ModelMapper modelMapper,
                       UserRepository userRepository,
                       CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean registerUser(RegisterDTO registerDTO) {

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        UserEntity user = modelMapper.map(registerDTO, UserEntity.class);
        user.setEmail(registerDTO.getEmail());
        userRepository.save(user);
        return true;
    }

    public boolean loginUser(LoginDTO loginDTO) {

        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isEmpty()) {
            return false;
        }

        this.currentUser.login(user.get());
        return true;
    }
    public boolean isLoggedIn() {
        return currentUser.isLoggedIn();
    }
    public Optional<UserEntity> getCurrentUser() {
        return this.userRepository.findById(this.currentUser.getId());
    }
    public String getCurrentUserName() {
        return this.currentUser.getUsername();
    }
}
