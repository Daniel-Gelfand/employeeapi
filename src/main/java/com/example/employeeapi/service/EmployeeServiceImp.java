package com.example.employeeapi.service;

import com.example.employeeapi.exception.EmployeeAlreadyExistsException;
import com.example.employeeapi.exception.EmployeeConflictException;
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


    EmployeeRepository employeeRepository;
    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    EmployeeConvertor employeeConvertor;
    @Autowired
    public void setEmployeeConvertor (EmployeeConvertor employeeConvertor){
        this.employeeConvertor = employeeConvertor;
    }


    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
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
    public Employee updateEmployee(EmployeeDto employeeToUpdateDto, String employeeEmail) {

        if (!employeeToUpdateDto.getEmployeeEmail().equals(employeeEmail)){
            validation(employeeToUpdateDto);
        }
        return employeeRepository.findEmployeeByEmployeeEmail(employeeEmail)
                .map(employee -> employeeRepository.save(employee.update(employeeConvertor.convertEmployeeDto(employeeToUpdateDto))))
                .orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"Email",employeeEmail)));

    }

    @Override
    public Employee insertNewEmployee(EmployeeDto employeeDto) {

        validation(employeeDto);
        return employeeRepository.save(employeeConvertor.convertEmployeeDto(employeeDto));
    }

    //TODO DELETE
    @Override
    public void deleteEmployee(String employeeEmail) {
        Employee employeeToUpdate = employeeRepository.findEmployeeByEmployeeEmail(employeeEmail)
                .orElseThrow(()-> new EmployeeNotFoundException(String.format(Constant.NOT_FOUND_MESSAGE,"Email",employeeEmail)));
        employeeRepository.delete(employeeToUpdate);
    }


    private void validation(EmployeeDto employeeDto){

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if ( employeeDto.getEmployeeFirstName() == null  || employeeDto.getEmployeeFirstName().isBlank()){
            throw new EmployeeConflictException(String.format("you must employee first name"));
        }


        if (employeeDto.getEmployeeLastName()==null || employeeDto.getEmployeeLastName().isBlank()){
            throw new EmployeeConflictException("you must employee last name");
        }

        if (employeeDto.getEmployeeEmail() == null || employeeDto.getEmployeeEmail().isBlank() ){
            throw new EmployeeConflictException("you must enter a email");
        }


        if (!employeeDto.getEmployeeEmail().matches(regexPattern) ){
            throw new EmployeeConflictException("you must enter valid email");
        }

        if (employeeRepository.existsByEmployeeEmail(employeeDto.getEmployeeEmail())){
            throw new EmployeeAlreadyExistsException(String.format(Constant.ALREADY_EXISTS_MESSAGE,"email", employeeDto.getEmployeeEmail()));
        }
    }
}
