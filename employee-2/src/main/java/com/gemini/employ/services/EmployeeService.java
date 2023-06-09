package com.gemini.employ.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gemini.employ.entities.Employee;
import com.gemini.employ.repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	// to access methods of jparepo we need to create object.
	@Autowired
	private EmployeeRepository employeerep;
	
	public List<Employee> getAllEmployees() {
		log.info("Getting all employees");
		return employeerep.findAll(); // to find all data in database
	}
	//Native query service
	public List<Employee> getEmployees(){
		log.info("Getiing all employees using native query");
		return employeerep.getEmployees();
	}
	
	public Employee getEmployeeByID(long id ) {
		log.info("Getting employees by id");
		List<Employee> employees=employeerep.findAll();
		Employee employee=null;
		
		for(Employee emp:employees) {
			if(emp.getId()==id) {
				employee=emp;
			}
		}
		return employee;
	}
	public Employee AddEmployee(Employee employee) {
		log.info("creating new Employee");
		employeerep.save(employee);
		return employee;
	}
	public Employee UpdateEmployee(Employee employee) {
		log.info("Updating an employee");
        employeerep.save(employee);
        return employee;
    }
	public String deleteemployee(long id) {
		log.info("Deleted an employee");
		employeerep.deleteById(id);
		return "Employee Removed";
	}
}