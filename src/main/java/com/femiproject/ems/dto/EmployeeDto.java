package com.femiproject.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Employee Dto class is used to transfer data between client and server. It is used as a response for restApi
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
