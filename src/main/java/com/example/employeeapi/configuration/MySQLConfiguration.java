package com.example.employeeapi.configuration;


import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import com.example.employeeapi.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class MySQLConfiguration {


    @Bean
    CommandLineRunner runner(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.deleteAll();

            Employee employee1 = Employee.builder().employeeEmail("danoyoy@gmail.com").employeeFirstName("Daniel").employeeLastName("Gelfand").build();
            Employee employee2 = Employee.builder().employeeEmail("josem@gmail.com").employeeFirstName("Jose").employeeLastName("Morinho").build();
            Employee employee3 = Employee.builder().employeeEmail("fakeemail1@gmail.com").employeeFirstName("Robot").employeeLastName("Tobor").build();
            Employee employee4 = Employee.builder().employeeEmail("fakeemail2@gmail.com").employeeFirstName("Nvidia").employeeLastName("Asus").build();
            Employee employee5 = Employee.builder().employeeEmail("intel@amd.com").employeeFirstName("Intel").employeeLastName("Amd").build();





            employeeRepository.saveAll(List.of(employee1,employee2,employee3,employee4,employee5));

        };
    }
}
