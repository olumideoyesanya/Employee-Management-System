package com.femiproject.ems.mapper;

import com.femiproject.ems.dto.EmployeeDto;
import com.femiproject.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){

        return  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAddress()
        );

    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getAddress()
        );

    }
}
