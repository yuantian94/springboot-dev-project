package com.RestAPI.cruddemo.service;

import com.RestAPI.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
