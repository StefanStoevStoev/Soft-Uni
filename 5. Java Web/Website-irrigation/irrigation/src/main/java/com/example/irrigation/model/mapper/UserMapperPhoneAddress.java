package com.example.irrigation.model.mapper;

import com.example.irrigation.model.DTO.UserPhoneAndAddressDTO;
import com.example.irrigation.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Mapper(componentModel = "spring")
public interface UserMapperPhoneAddress {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserPhoneAndAddressDTO userPhoneAndAddressDTO);
}
