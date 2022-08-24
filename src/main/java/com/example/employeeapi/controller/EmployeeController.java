package com.example.employeeapi.controller;


import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import com.example.employeeapi.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/{employeeEmail}")
    ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String employeeEmail){
        return ResponseEntity.ok().body(employeeService.getEmployeeByEmail(employeeEmail));
    }

    @PutMapping("/{id}")
    ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeToUpdateDto, @PathVariable Long id){
        Employee employee = employeeService.updateEmployee(employeeToUpdateDto,id);

        return ResponseEntity.ok().body(employee);
    }


    @PostMapping
    ResponseEntity<Employee> insertEmployee(@RequestBody EmployeeDto newEmployeeDto){
        Employee employee = employeeService.insertNewEmployee(newEmployeeDto);

        return ResponseEntity.ok().body(employee);
    }


}
