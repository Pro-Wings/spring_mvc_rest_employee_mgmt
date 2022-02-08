package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Employee;
import com.prowings.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<?> save(@RequestBody Employee emp)
	{
		long id = employeeService.save(emp);
		return ResponseEntity.ok("Employee record saved successfully with : "+id);
	}
	
	//get employee by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id)
	{
		
		Employee emp =  employeeService.get(id);
		
		return ResponseEntity.ok().body(emp);
	}
	
	//get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		
		List<Employee> emplist =  employeeService.list();
		
		return ResponseEntity.ok().body(emplist);
	}
	
	//update an employee
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Employee emp)
	{
		employeeService.update(id, emp);
		
		return ResponseEntity.ok("Employee record updated successfully");
	}
	
	//delete employee by id
	//get employee by id
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id)
	{
		employeeService.delete(id);
		
		return ResponseEntity.ok().body("Record deleted successfully");
	}

	

}
