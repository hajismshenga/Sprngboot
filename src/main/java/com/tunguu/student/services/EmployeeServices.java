package com.tunguu.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunguu.student.model.Employee;
import com.tunguu.student.repository.EmployeeRepository;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
}
