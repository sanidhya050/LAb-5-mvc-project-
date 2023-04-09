package com.gl.employemanagementsystem.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employemanagementsystem.dao.EmployeeRepository;
import com.gl.employemanagementsystem.entity.Employee;

@Service

public class EmployeeServiceImplementation  implements EmployeeService {
	
    @Autowired
	private EmployeeRepository employeeRepository;
    
    public EmployeeServiceImplementation(EmployeeRepository employeerepository) {
    	super();
    	this.employeeRepository = employeeRepository;
    }
    
    @Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	}

    @Override
	public Employee findEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		
		if (employee == null)
			throw new RuntimeException("Did not find the employee id:" + id );
		else
			return employee;
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
    }
	
	@Override
	public void deleteEmployeeById(Long id) {
		 this.employeeRepository .deleteById(id);
		
	}

}


