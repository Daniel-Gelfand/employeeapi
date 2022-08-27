package com.example.employeeapi.pojo;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee{

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long employeeID;

    @Column(name = "FIRST_NAME",nullable = false)
    private String employeeFirstName;

    @Column(name = "LAST_NAME",nullable = false)
    private String employeeLastName;

    @Column(name = "EMAIL",nullable = false,unique = true)
    private String employeeEmail;

    public Employee() {

    }

    @Builder
    public Employee(String employeeFirstName, String employeeLastName, String employeeEmail ) {
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
