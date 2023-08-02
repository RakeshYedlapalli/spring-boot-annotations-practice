package com.gap.sample.practice.Springboot_practice.repositories;

import com.gap.sample.practice.Springboot_practice.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
