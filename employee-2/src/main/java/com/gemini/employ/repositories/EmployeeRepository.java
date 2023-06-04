package com.gemini.employ.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gemini.employ.entities.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value="select *from Employee", nativeQuery=true)
	public List<Employee> getEmployees();
}
