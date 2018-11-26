package com.cursosLatam.angularSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursosLatam.angularSpringBoot.model.Employee;
import com.cursosLatam.angularSpringBoot.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping(path = "/employees")
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@PostMapping(path = "/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

}
