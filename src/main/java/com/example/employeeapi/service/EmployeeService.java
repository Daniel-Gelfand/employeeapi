package com.example.employeeapi.service;


import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployees();

    Employee getEmployeeByEmail(String employeeEmail);

    Employee updateEmployee(EmployeeDto employeeToUpdateDto, Long id);

    Employee insertNewEmployee(EmployeeDto newEmployee);

}
