package com.example.irrigation2.model.mapper;

import com.example.irrigation2.model.entity.UserEntity;
import com.example.irrigation2.model.views.UserViewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDetailsUserEntity(UserViewModel userViewModel);
}