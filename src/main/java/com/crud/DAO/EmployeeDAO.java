package com.crud.DAO;

import com.crud.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    Boolean save();
    int update();
    Boolean deleteById();
    Boolean save(Employee employee);
    int update(Employee employee);
    Boolean deleteByid(int id);
    Boolean delete(Employee employee);
}
