package com.nrifintech.training.secureapp.mappers;

import com.nrifintech.training.secureapp.dtos.UserDTO;
import com.nrifintech.training.secureapp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NameMapper.class})
public interface UserMapper {
    @Mapping(target = "credentials.email", source = "email")
    @Mapping(target = "credentials.password", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "email", source = "credentials.email")
    UserDTO toDTO(User user);
}
