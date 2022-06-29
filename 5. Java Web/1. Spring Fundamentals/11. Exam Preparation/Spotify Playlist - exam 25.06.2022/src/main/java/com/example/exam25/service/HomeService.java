package com.example.exam25.service;

import com.example.exam25.model.DTO.LoginDTO;
import com.example.exam25.model.DTO.RegisterDTO;
import com.example.exam25.model.DTO.SongDTO;
import com.example.exam25.model.DTO.SongsByGenreDTO;
import com.example.exam25.model.entity.StyleEntity;
import com.example.exam25.model.entity.UserEntity;
import com.example.exam25.repository.UserRepository;
import com.example.exam25.seasson.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public HomeService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
        this.currentUser = currentUser;
    }

    public void register(RegisterDTO registerDTO){
        UserEntity userEntity = modelMapper.map(registerDTO, UserEntity.class);
        userRepository.save(userEntity);
    }

    public boolean login(LoginDTO loginDTO){
        Optional<UserEntity> userEntity = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if(userEntity.isEmpty()){
            return false;
        }
        return true;
    }

    public void logout(){
        currentUser.logout();
    }

    public UserEntity getCurrentUser(){
        return userRepository.findById(currentUser.getId()).get();
    }

    public boolean isActive(){
        return currentUser.isLoggedIn();
    }
}
