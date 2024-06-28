package com.tunguu.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunguu.student.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
