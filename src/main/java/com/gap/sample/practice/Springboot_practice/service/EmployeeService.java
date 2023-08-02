package com.gap.sample.practice.Springboot_practice.service;

import com.gap.sample.practice.Springboot_practice.entity.Employee;
import com.gap.sample.practice.Springboot_practice.exception.EmployeeCouldntBeSavedInDatabase;
import com.gap.sample.practice.Springboot_practice.exception.EmployeeNotFoundInDatabaseException;
import com.gap.sample.practice.Springboot_practice.exception.NoEmployeesFoundInDatabase;
import com.gap.sample.practice.Springboot_practice.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> listOfEmployees = employeeRepository.findAll();
        if(!CollectionUtils.isEmpty(listOfEmployees)) {
            return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
        }else{
            throw new NoEmployeesFoundInDatabase("None of the employees found in DB exception");
        }
    }

    public ResponseEntity<Employee> saveEmployee(Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        if(employee1.getFirstName().equals(employee.getFirstName())){
            return new ResponseEntity<>(employee1,HttpStatus.OK);
        }else{
            throw new EmployeeCouldntBeSavedInDatabase("Employee couldn't be saved in database");
        }
    }

    public ResponseEntity<Employee> findById(String id) {
         Optional<Employee> employee =  employeeRepository.findById(id);
         if(employee.isPresent()){
             Employee emp = employee.get();
             return new ResponseEntity<>(emp,HttpStatus.OK);
         }else{
             throw  new EmployeeNotFoundInDatabaseException("There are no employees found in Database with given ID");
         }
    }
}
