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
public class SignUpRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
