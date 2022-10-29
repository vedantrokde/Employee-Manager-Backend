package com.code.employeemanager.service;

import java.util.List;
import java.util.UUID;

import com.code.employeemanager.exception.UserNotFoundException;
import com.code.employeemanager.model.Employee;
import com.code.employeemanager.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo){
        this.repo = repo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return repo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}
