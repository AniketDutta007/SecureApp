package com.nrifintech.training.secureapp.mappers;

import com.nrifintech.training.secureapp.dtos.RefreshTokenDTO;
import com.nrifintech.training.secureapp.models.RefreshToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefreshTokenMapper {
    RefreshToken toEntity(RefreshTokenDTO refreshTokenDTO);
    RefreshTokenDTO toDTO(RefreshToken refreshToken);
}
