package com.example.irrigation.model.mapper;

import com.example.irrigation.model.DTO.UserRegisterDTO;
import com.example.irrigation.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDTO registerDTO);
}