package com.example.coffeeshop2.service;

import com.example.coffeeshop2.model.entity.DTO.UserLoginDTO;
import com.example.coffeeshop2.model.entity.DTO.UserRegisterDTO;
import com.example.coffeeshop2.model.entity.UserEntity;
import com.example.coffeeshop2.model.entity.view.UserViewModel;
import com.example.coffeeshop2.repositories.UserRepository;
import com.example.coffeeshop2.seasson.CurrentUser;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper,
                       CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    public boolean registerUser(UserRegisterDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            return false;
        }

//        todo duplicate email
//        todo duplicate usename

        UserEntity user = new UserEntity();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        this.userRepository.save(user);
        return true;
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> user = userRepository
                .findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
//        System.out.println(userLoginDTO.getUsername() + " " + userLoginDTO.getPassword());
        if (user.isEmpty()) {
            return false;
        }
//        System.out.println(user.get());
        this.currentUser.login(user.get());
        return true;
    }

    public UserEntity findByUserId(long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<UserViewModel> findAllUserAndCountOfOrdersByCountDesc(){
        return userRepository.findAllByOrdersCountDescending().stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());
                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
