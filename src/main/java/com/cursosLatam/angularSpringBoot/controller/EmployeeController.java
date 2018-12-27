package com.cursosLatam.angularSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path = "/employees/{id}")
	public Employee getAllEmployee(@PathVariable Integer id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + id));
	}
	
	@GetMapping(path = "/employees/identification/{identification}")
	public Employee getEmployeeByIdentification(@PathVariable String identification) {
		return employeeRepository.findByIdentification(identification);
	}

	@PostMapping(path = "/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@DeleteMapping(path = "/employee/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeRepository.deleteById(id);
	}

	@PutMapping(path = "/employees/{id}")
	public void updateEmployee(@PathVariable Integer id, @RequestBody Employee employee)
			throws ResourceNotFoundException {
		Employee currentEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + id));
		currentEmployee.setUltimatix(employee.getUltimatix());
		currentEmployee.setIdentification(employee.getIdentification());
		currentEmployee.setName(employee.getName());
		currentEmployee.setLastName(employee.getLastName());
		currentEmployee.setBirthDate(employee.getBirthDate());

		employeeRepository.save(currentEmployee);
	}

}
