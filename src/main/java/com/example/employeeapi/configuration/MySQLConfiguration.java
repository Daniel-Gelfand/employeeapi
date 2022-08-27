package com.example.employeeapi.configuration;


import com.example.employeeapi.pojo.Employee;
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
            Employee employee2 = Employee.builder().employeeEmail("jordan@nike.com").employeeFirstName("Michael").employeeLastName("Jordan").build();
            Employee employee3 = Employee.builder().employeeEmail("shaquille@gmail.com").employeeFirstName("Shaquille").employeeLastName("ONeal").build();
            Employee employee4 = Employee.builder().employeeEmail("lebron@james.com").employeeFirstName("Lebron").employeeLastName("James").build();
            Employee employee5 = Employee.builder().employeeEmail("steph@hotmail.com").employeeFirstName("Steph").employeeLastName("Curry").build();
            //TODO: DELETE

            employeeRepository.saveAll(List.of(employee1,employee2,employee3,employee4,employee5));

            log.info("Adding default data to database");
        };
    }
}
