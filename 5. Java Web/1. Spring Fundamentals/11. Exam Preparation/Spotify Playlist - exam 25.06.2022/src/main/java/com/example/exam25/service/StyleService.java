package com.example.exam25.service;

import com.example.exam25.model.entity.StyleEntity;
import com.example.exam25.model.entity.enums.StyleEnum;
import com.example.exam25.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StyleService {

    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

//    public Optional<StyleEntity> findStyleByName(StyleEnum style){
//        return this.styleRepository.findByName(style);
//    }
}
