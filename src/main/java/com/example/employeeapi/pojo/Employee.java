package com.example.employeeapi.pojo;


import com.example.employeeapi.pojo.dto.EmployeeDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee{

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME",nullable = false)
    private String employeeFirstName;

    @Column(name = "LAST_NAME",nullable = false)
    private String employeeLastName;

    @Column(name = "EMAIL",nullable = false,unique = true)
    private String employeeEmail;


    @Builder
    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeEmail = employeeEmail;
    }

    public Employee update(Employee detailsToUpdate){
        this.setEmployeeFirstName(detailsToUpdate.getEmployeeFirstName());
        this.setEmployeeLastName(detailsToUpdate.getEmployeeLastName());
        this.setEmployeeEmail(detailsToUpdate.getEmployeeEmail());
        return this;
    }
}
