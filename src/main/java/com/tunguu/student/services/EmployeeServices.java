package com.tunguu.student.services;

import java.util.List;
import java.util.Optional;

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

    public Employee addEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee getEmployeeById(Long empId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        return optionalEmployee.get();
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    public Employee updateEmployee(Employee emp) {
        Employee existingEmp = employeeRepository.findById(emp.getId()).get();
        existingEmp.setFirstName(emp.getFirstName());
        existingEmp.setLastName(emp.getLastName());
        existingEmp.setEmail(emp.getEmail());
        Employee updateEmployee = employeeRepository.save(existingEmp);
        return updateEmployee;
    }
    
}
