package com.nrifintech.training.secureapp.mappers;

import com.nrifintech.training.secureapp.dtos.NameDTO;
import com.nrifintech.training.secureapp.models.Name;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NameMapper {
    Name toEntity(NameDTO nameDTO);
    NameDTO toDTO(Name name);
}
