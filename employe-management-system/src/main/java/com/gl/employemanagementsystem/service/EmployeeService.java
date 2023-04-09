package com.gl.employemanagementsystem.service;

import java.util.List;


import com.gl.employemanagementsystem.entity.Employee;

public interface EmployeeService {
	
	// view all records
	
	public List<Employee> findAllEmployees();
	
	// insert new records
	 Employee saveEmployee(Employee employee);
	 
	// update new records 
	 
	 Employee findEmployeeById(Long id );
	 
	// delete existing records 

	 void deleteEmployeeById(Long id );

	public Employee updateEmployee(Employee existingEmployee);

}
