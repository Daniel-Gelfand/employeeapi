package com.example.employeeapi.utils;

import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConvertorImp implements EmployeeConvertor {


    //TODO DELETE NICKNAME
    @Override
    public Employee convertEmployeeDto(EmployeeDto employeeDto) {
        return Employee.builder()
                .employeeLastName(employeeDto.getEmployeeLastName())
                .employeeFirstName(employeeDto.getEmployeeFirstName())
                .employeeEmail(employeeDto.getEmployeeEmail())
                .build();
    }




}
