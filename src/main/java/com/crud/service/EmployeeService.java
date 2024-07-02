package com.crud.service;

import com.crud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {


    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void delete(int id);
}
