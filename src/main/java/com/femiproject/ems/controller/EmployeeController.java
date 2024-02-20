package com.femiproject.ems.controller;

import com.femiproject.ems.dto.EmployeeDto;
import com.femiproject.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This Annotation means this class is ready to implement Http methods
@AllArgsConstructor
@RestController
//This defines the base urls for all the rest Apis to be built in this controller
@RequestMapping("/api/employees")
public class EmployeeController {

    // Dependency injection
    private EmployeeService employeeService;

    //Build Add Employee Rest API
    //This Annotation makes it a rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){//@RequestBody will accept the Json from http request and it will convert the Json into employee Dta Object
      EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
