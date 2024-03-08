package com.femiproject.ems.service.impl;

import com.femiproject.ems.dto.EmployeeDto;
import com.femiproject.ems.entity.Employee;
import com.femiproject.ems.exception.ResourceNotFoundException;
import com.femiproject.ems.mapper.EmployeeMapper;
import com.femiproject.ems.repository.EmployeeRepository;
import com.femiproject.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

     Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee with given id does not exist" + employeeId)
        );

            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setAddress(updatedEmployee.getAddress());

           Employee updatedEmployeeObj = employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
      Employee employee =  employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee with given id does not exist" + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
