package com.cursosLatam.angularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosLatam.angularSpringBoot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
