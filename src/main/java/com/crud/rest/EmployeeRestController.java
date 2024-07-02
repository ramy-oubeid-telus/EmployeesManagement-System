package com.crud.rest;

import com.crud.DAO.EmployeeDAO;
import com.crud.entity.Employee;
import com.crud.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        logger.debug("Received request for /api/employees");

        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        logger.debug("Returning employee list");
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/version")
    public String test() {
        return "2.2.1";
    }
}
