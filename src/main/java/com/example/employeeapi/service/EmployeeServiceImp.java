package com.example.employeeapi.service;

import com.example.employeeapi.exception.EmployeeAlreadyExistsException;
import com.example.employeeapi.exception.EmployeeNotFoundException;
import com.example.employeeapi.pojo.Employee;
import com.example.employeeapi.pojo.dto.EmployeeDto;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.utils.Constant;
import com.example.employeeapi.utils.EmployeeConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    EmployeeConvertor employeeConvertor;


    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeByEmail(String employeeEmail) {

        return employeeRepository
                .getEmployeesByEmployeeEmail(employeeEmail)
                .orElseThrow(()->
                        new EmployeeNotFoundException(
                                String.format(Constant.NOT_FOUND_MESSAGE,"Email",employeeEmail)));
    }

    @Override
    public Employee updateEmployee(EmployeeDto employeeToUpdate, Long id) {

//        if (employeeRepository.existsById(id)){
//            employeeRepository.findEmployeeById(id).map(employee -> employeeRepository.save(employee.update(employeeToUpdate))).orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id)));
//        }
//        else {
//            throw new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id));
//        }

        return employeeRepository.findEmployeeById(id)
                .map(employee -> employeeRepository.save(
                        employee.update((employeeToUpdate.toEntity()))))
                .orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id)));

//        return employeeRepository.findEmployeeById(id)
//                .map(employee ->
//                        employeeRepository.save(employee.update(employeeToUpdate))).orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"id",id)));
    }


    @Override
    public Employee insertNewEmployee(EmployeeDto employeeDto) {
        if (employeeRepository.existsByEmployeeEmail(employeeDto.getEmployeeEmail())){
            throw new EmployeeAlreadyExistsException(String.format(Constant.ALREADY_EXISTS_MESSAGE,"email", employeeDto.getEmployeeEmail()));
        }

        //TODO: ask why it not working?

//        Employee employee = employeeConvertor.convertEmployeeDto(employeeDto);
//        return employeeRepository.save(employee);

        Employee employee = employeeDto.toEntity();
        return employeeRepository.save(employee);
    }
}
