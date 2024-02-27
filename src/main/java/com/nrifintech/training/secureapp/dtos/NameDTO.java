package com.nrifintech.training.secureapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NameDTO {
    private String firstName;
    private String middleName;
    private String lastName;
}
