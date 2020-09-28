package com.ajt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
