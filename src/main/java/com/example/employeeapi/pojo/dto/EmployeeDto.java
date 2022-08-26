package com.example.employeeapi.pojo.dto;

import com.example.employeeapi.pojo.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EmployeeDto {

    private String employeeFirstName;

    private String employeeLastName;

    private String employeeEmail;

//    public EmployeeDto(){
//
//    }

    public EmployeeDto(Employee employee) {
        this.employeeFirstName = employee.getEmployeeFirstName();
        this.employeeLastName = employee.getEmployeeLastName();
        this.employeeEmail = employee.getEmployeeEmail();

    }

    //TODO: DELETE THIS AND USE CONVERTOR CLASS
    public Employee toEntity(){
        Employee employee = Employee.builder()
                .employeeEmail(this.getEmployeeEmail())
                .employeeFirstName(this.getEmployeeFirstName())
                .employeeLastName(this.getEmployeeLastName())
                .build();
        return employee;
    }
}
