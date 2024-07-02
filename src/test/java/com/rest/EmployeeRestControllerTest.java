package com.rest;

import com.crud.DAO.EmployeeDAO;
import com.crud.entity.Employee;
import com.crud.rest.EmployeeRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeRestControllerTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private EmployeeRestController employeeRestController;

    private List<Employee> employeeList;

    @BeforeEach
    public void setUp() {
        Employee emp1 = new Employee("John", "Doe", "john.doe@example.com");
        emp1.setId(1);
        Employee emp2 = new Employee("Jane", "Smith", "jane.smith@example.com");
        emp2.setId(2);
        employeeList = Arrays.asList(emp1, emp2);
    }

    @Test
    public void testFindAll() {
        when(employeeDAO.findAll()).thenReturn(employeeList);

        ResponseEntity<List<Employee>> response = employeeRestController.findAll();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("John", response.getBody().get(0).getFistName());
        assertEquals("Jane", response.getBody().get(1).getFistName());
    }

    @Test
    public void testFindAllNoContent() {
        when(employeeDAO.findAll()).thenReturn(Arrays.asList());

        ResponseEntity<List<Employee>> response = employeeRestController.findAll();
        assertEquals(TRUE,response.hasBody());
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testTestEndpoint() {
        String response = employeeRestController.test();
        assertEquals("2.2.1", response);
    }
}

