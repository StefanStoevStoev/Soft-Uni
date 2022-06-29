package com.example.exam25.service;

import com.example.exam25.model.DTO.SongDTO;
import com.example.exam25.model.entity.SongEntity;
import com.example.exam25.model.entity.enums.StyleEnum;
import com.example.exam25.repository.SongRepository;
import com.example.exam25.repository.StyleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleRepository styleRepository;

    public SongService(SongRepository songRepository,
                       ModelMapper modelMapper, StyleRepository styleRepository) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleRepository = styleRepository;
    }

    public void addSong(SongDTO songDTO){
        SongEntity song = modelMapper.map(songDTO, SongEntity.class);
        song.setStyle(styleRepository.findByName(songDTO.getStyle()));
        songRepository.save(song);
    }

    public List<SongEntity> getStyleSongs(StyleEnum styleEnum){
        return songRepository.findAllByStyleName(styleEnum);
    }

    public SongEntity getById(Long songId){
        return songRepository.getById(songId);
    }
}
