package com.example.employeeapi.repository;

import com.example.employeeapi.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> getEmployeesByEmployeeEmail(String employeeEmail);

    boolean existsByEmployeeEmail(String employeeEmail);

    Optional<Employee> findEmployeeById(Long id);

    boolean existsById(Long id);



}
