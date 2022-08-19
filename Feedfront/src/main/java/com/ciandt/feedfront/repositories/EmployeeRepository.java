package com.ciandt.feedfront.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.feedfront.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
	