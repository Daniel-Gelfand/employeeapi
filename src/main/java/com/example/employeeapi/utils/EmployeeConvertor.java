package com.example.employeeapi.utils;

import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;

public interface EmployeeConvertor {

    Employee convertEmployeeDto(EmployeeDto employeeDto);
}
