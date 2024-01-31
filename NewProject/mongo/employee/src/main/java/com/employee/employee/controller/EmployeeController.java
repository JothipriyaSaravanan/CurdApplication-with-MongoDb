package com.employee.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeRepo;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping("/addEmp")
	public String addEmp(@RequestBody Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp.getId();

	}

	@GetMapping("/getAllEmps")
	public List<Employee> getAllEmps() {
		return employeeRepo.findAll();
	}

	@GetMapping("/getEmp/{id}")
	public Optional<Employee> getEmp(@PathVariable String id) {
		return employeeRepo.findById(id);
	}

	@PostMapping("/updateEmp/{id}")
	public Employee updateEmp(@PathVariable String id, @RequestBody Employee updatedEmployee) {
		updatedEmployee.setId(id);
		return employeeRepo.save(updatedEmployee);
	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable String id) {
		employeeRepo.deleteById(id);
		return "Successfully Deleted";
	}

	@GetMapping("/getNthLevelManager/{employeeId}/{level}")
	public ResponseEntity<?> getNthLevelManager(@PathVariable String employeeId, @PathVariable int level) {
		
		if(level>=3 || level<=0) {
			String errorMessage = "Please enter a valid manager level.";
	        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}
		
		Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);

		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			Employee nthLevelManager = findNthLevelManager(employee.getReportsTo(), level);

			if (nthLevelManager != null ) {
				return new ResponseEntity<>(nthLevelManager, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private Employee findNthLevelManager(String employeeId, int level) {

		if (employeeId == null || level <= 0) {
			return null;
		}

		Employee employee = null;
		for (int i = 1; i <= level; i++) {

			Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
			if (optionalEmployee.isPresent()) {
				employee = optionalEmployee.get();
				employeeId = employee.getReportsTo();
			}
		}
		return employee;
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<Page<Employee>> getAllEmployeesWithPaginationAndSorting(
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "employeeName") String sortBy) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
		Page<Employee> employees = employeeRepo.findAll(pageable);

		if (!employees.isEmpty()) {
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}