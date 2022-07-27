package com.example.irrigation.model.mapper;

import com.example.irrigation.model.DTO.AuthDTO;
import com.example.irrigation.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthModelDTO {
    @Mapping(target = "active", constant = "true")
    UserEntity authDetailsUserEntity(AuthDTO authDTO);
}
