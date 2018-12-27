package com.cursosLatam.angularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cursosLatam.angularSpringBoot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("SELECT e FROM Employee e WHERE e.identification = ?1 ")
	Employee findByIdentification(String identification);
}
