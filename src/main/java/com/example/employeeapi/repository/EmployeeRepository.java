package com.example.employeeapi.repository;

import com.example.employeeapi.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> getEmployeesByEmployeeEmail(String employeeEmail);

    Optional<Employee> findEmployeeByEmployeeEmail(String employeeEmail);

    boolean existsByEmployeeEmail(String employeeEmail);

    boolean existsById(Long id);




}
