package com.femiproject.ems.service.impl;

import com.femiproject.ems.dto.EmployeeDto;
import com.femiproject.ems.entity.Employee;
import com.femiproject.ems.mapper.EmployeeMapper;
import com.femiproject.ems.repository.EmployeeRepository;
import com.femiproject.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Converting EmployeeDto into employee Jpa because we have to store the Entity into the database using employeeMapper class to map employee Dto to employee jpa
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // this saves jpa entity into the database
       Employee savedEmployee = employeeRepository.save(employee);

       // this sends the saved Employee back to the client
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
