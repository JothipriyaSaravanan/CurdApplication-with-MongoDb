package com.employee.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.employee.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, String> {

}
