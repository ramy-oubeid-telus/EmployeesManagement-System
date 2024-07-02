package com.crud.service;

import com.crud.DAO.EmployeeDAO;
import com.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
