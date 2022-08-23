package com.example.employeeapi.pojo.dto;

import com.example.employeeapi.pojo.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Value;

@Value
@JsonPropertyOrder({"employeeFirstName","employeeLastName","employeeEmail"})
public class EmployeeDto {


    @JsonIgnore
    private Employee employee;


    public String getEmployeeFirstName(){
        return String.format("%s", employee.getEmployeeFirstName());
    }

    public String getEmployeeLastName(){
        return String.format("%s",employee.getEmployeeLastName());
    }

    public String getEmployeeEmail(){
        return String.format("%s",employee.getEmployeeEmail());
    }


    public void setEmployeeEmail(EmployeeDto employeeToSet){

    }

}
