package com.ajt.service;

import java.util.List;
import java.util.Optional;

import com.ajt.model.Employee;

public interface IEmployeeService {

	public Integer createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Optional<Employee> getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
	
}
