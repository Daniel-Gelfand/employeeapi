package com.example.employeeapi.service;

import com.example.employeeapi.exception.EmployeeAlreadyExistsException;
import com.example.employeeapi.exception.EmployeeNotFoundException;
import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees =
                StreamSupport.stream(employeeRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getEmployeeByEmail(String employeeEmail) {
        com.example.employeeapi.pojo.Employee employee = employeeRepository
                .getEmployeesByEmployeeEmail(employeeEmail)
                .orElseThrow(()->
                        new EmployeeNotFoundException(
                                String.format(Constant.NOT_FOUND_MESSAGE,"Email",employeeEmail)));

        return employee;
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeToUpdate, Long id) {
//        if (employeeRepository.existsById(id)){
//            employeeRepository.findEmployeeById(id).map(employee -> employeeRepository.save(employee.update(employeeToUpdate))).orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id)));
//        }
//        else {
//            throw new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id));
//        }

        //return employeeRepository.findEmployeeById(id).map(employee -> employeeRepository.save(employee.update(employeeToUpdate))).orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id)));

        return null;
    }


    //TODO: finish it with dto
    @Override
    public Employee insertNewEmployee(EmployeeDto employeeDto) {
//        if (employeeRepository.existsByEmployeeEmail(employeeDto.getEmployeeEmail())){
//            throw new EmployeeAlreadyExistsException(String.format(Constant.ALREADY_EXISTS_MESSAGE,"email", employeeDto.getEmployeeEmail()));
//        }
        //TODO: check maybe the id OR create DTO object
        //return employeeRepository.save(employeeDto);
        return null;
    }
}
