package com.nrifintech.training.secureapp.dtos;

import com.nrifintech.training.secureapp.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private NameDTO name;
    private String email;
    private Role role;
}
