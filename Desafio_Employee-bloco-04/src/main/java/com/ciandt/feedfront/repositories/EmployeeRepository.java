package com.ciandt.feedfront.repositories;

import com.ciandt.feedfront.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);
}