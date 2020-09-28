package com.ajt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajt.model.Employee;
import com.ajt.repo.EmployeeRepository;
import com.ajt.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Integer createEmployee(Employee employee) {
		return repo.save(employee).getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Optional<Employee> getOneEmployee(Integer id) {
		return repo.findById(id);
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent())
			repo.delete(optional.get());
	}

}
