package com.femiproject.ems.controller;

import com.femiproject.ems.dto.EmployeeDto;
import com.femiproject.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//This Annotation means this class is ready to implement Http methods
@CrossOrigin("*")
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
    // Build get Employee RestApi
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
       EmployeeDto employeeDto  = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    //Build getAll Employees Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok(employees);
    }
    //Build Update Employee Rest Api
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){

       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);

       return ResponseEntity.ok(employeeDto);

    }
    //Build delete employee Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
         employeeService.deleteEmployee(employeeId);

         return  ResponseEntity.ok("Employee deleted successfully");
    }

}
