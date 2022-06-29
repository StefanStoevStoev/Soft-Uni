package com.example.exam25.service;

import com.example.exam25.model.DTO.LoginDTO;
import com.example.exam25.model.DTO.RegisterDTO;
import com.example.exam25.model.entity.SongEntity;
import com.example.exam25.model.entity.UserEntity;
import com.example.exam25.repository.UserRepository;
import com.example.exam25.seasson.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final HomeService homeService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository,
                       HomeService homeService,
                       CurrentUser currentUser,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.homeService = homeService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public void addSongToCurrentUser() {
        homeService.getCurrentUser();
    }

    public void saveSong(SongEntity songEntity) {
        UserEntity userEntity = homeService.getCurrentUser();
        userEntity.addSongToPlaylist(songEntity);
        userRepository.save(userEntity);
    }

//    @Transactional
    public List<SongEntity> getPlaylist() {
        return userRepository.findById(currentUser.getId()).get().getPlaylist();
    }

    public void cleanPlaylist() {
        UserEntity userEntity = userRepository.findById(currentUser.getId()).get();
        userEntity.removeAllSongsFromPlaylist();
        userRepository.save(userEntity);
    }

    public String getPlaylistDuration() {
        int sum = getPlaylist().stream()
                .mapToInt(SongEntity::getDuration)
                .sum();
        long MM = sum / 60;
        long SS = sum % 60;
        return String.format("%02d:%02d", MM, SS);
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<UserEntity> userEntity = this.userRepository
                .findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (userEntity.isEmpty()) {
            return false;
        }
        currentUser.login(userEntity.get());
        return true;
    }

    public void register(RegisterDTO registerDTO) {
        UserEntity userEntity = modelMapper.map(registerDTO, UserEntity.class);
        userRepository.save(userEntity);
    }
}
