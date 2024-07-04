package com.tunguu.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunguu.student.model.Employee;
import com.tunguu.student.services.EmployeeServices;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> emp = employeeServices.getAllEmployees();
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
    {
        Employee savedEmployee = employeeServices.addEmployee(emp);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @GetMapping("/employeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId)
    {
        Employee emp = employeeServices.getEmployeeById(empId);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId)
    {
        employeeServices.deleteEmployee(empId);
        return new ResponseEntity<String>("Employee deleted sucessfully",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee emp)
    {
        emp.setId(empId);
        Employee empUpdate = employeeServices.updateEmployee(emp);
        return new ResponseEntity<>(empUpdate,HttpStatus.CREATED);
    }





   
    
}
