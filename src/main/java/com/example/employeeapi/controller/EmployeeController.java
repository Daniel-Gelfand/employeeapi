package com.example.employeeapi.controller;


import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/{employeeEmail}")
    ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String employeeEmail){
        return ResponseEntity.ok().body(employeeService.getEmployeeByEmail(employeeEmail));
    }

    @PutMapping("/{employeeEmail}")
    ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeToUpdateDto, @PathVariable String employeeEmail){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employeeToUpdateDto,employeeEmail));
    }

    @PostMapping
    ResponseEntity<Employee> insertEmployee(@RequestBody EmployeeDto newEmployeeDto){
        return ResponseEntity.ok().body(employeeService.insertNewEmployee(newEmployeeDto));
    }

}
