package com.RestAPI.cruddemo.dao;

import com.RestAPI.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
