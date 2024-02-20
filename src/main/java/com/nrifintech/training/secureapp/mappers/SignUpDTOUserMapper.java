package com.nrifintech.training.secureapp.mappers;

import com.nrifintech.training.secureapp.dtos.SignUpRequestDTO;
import com.nrifintech.training.secureapp.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SignUpDTOUserMapper {
    @Mapping(target = "name.firstName", source = "firstName")
    @Mapping(target = "name.lastName", source = "lastName")
    @Mapping(target = "credentials.email", source = "email")
    @Mapping(target = "credentials.password", source = "password")
    User signUpDTOToUser(SignUpRequestDTO signUpRequestDTO);
}
