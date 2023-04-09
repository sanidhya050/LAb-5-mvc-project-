package com.gl.employemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.employemanagementsystem.entity.Employee;
import com.gl.employemanagementsystem.service.EmployeeService;

@Controller
@RequestMapping("/Employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	private Model model;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/hello")

	public String sayHello(Model model) {

		return "helloworld";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "createEmployeePage";
	}

	@GetMapping("/list")

	public String listEmployees(Model Model) {

		List<Employee> Employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		
		return "employeeRecords";
	}

	@PostMapping("/list")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);

		return " redirect:/employees/list";
	}

	@GetMapping("/ShowFormForUpdate/{id}")
	public String updateEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("employee", employee);
		return "editEmployee";
	}

	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmployee = employeeService.findEmployeeById(id);
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		employeeService.updateEmployee(existingEmployee);
		return " redirect:/employees/list";
	}

	@GetMapping("{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees/list";

	}
}
