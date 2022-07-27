package com.example.irrigation.model.mapper;

import com.example.irrigation.model.entity.UserEntity;
import com.example.irrigation.model.views.UserViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDetailsUserEntity(UserViewModel userViewModel);
}