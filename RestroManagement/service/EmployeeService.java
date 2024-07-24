package com.RestroManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RestroManagement.Dao.EmployeeRepository;
import com.RestroManagement.Entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> AllEmployees(){
		return repository.findAll();		
	}
	
	public Employee SaveEmployee(Employee employee) {
		return repository.save(employee);		
	}
	
	public Employee findEmployeeById(int id) {
		return repository.findById(id).get();		
	}
	
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	public void DeleteEmployeeById(int id) {
		repository.deleteById(id);
	}
}
