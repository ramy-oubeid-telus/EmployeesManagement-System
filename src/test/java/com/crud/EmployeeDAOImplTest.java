package com.crud;

import com.crud.DAO.EmployeeDAOImpl;
import com.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeDAOImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<Employee> query;

    @InjectMocks
    private EmployeeDAOImpl employeeDAO;

    private List<Employee> employeeList;

    @BeforeEach
    public void setUp() {
        Employee emp1 = new Employee("John", "Doe", "john.doe@example.com");
        Employee emp2 = new Employee("Jane", "Smith", "jane.smith@example.com");
        emp1.setId(1);
        emp2.setId(2);
        employeeList = Arrays.asList(emp1, emp2);
    }

    @Test
    public void testFindAll() {
        when(entityManager.createQuery("SELECT e FROM Employee e", Employee.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(employeeList);

        List<Employee> result = employeeDAO.findAll();
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getFistName());
        assertEquals("Jane", result.get(1).getFistName());

        verify(entityManager, times(1)).createQuery("SELECT e FROM Employee e", Employee.class);
        verify(query, times(1)).getResultList();
    }

    @Test
    public void testFindById() {
        Employee emp = new Employee("John", "Doe", "john.doe@example.com");
        emp.setId(1);

        when(entityManager.find(Employee.class, 1)).thenReturn(emp);

        Employee result = employeeDAO.findById(1);
        assertEquals("John", result.getFistName());
        assertEquals("Doe", result.getLastName());

        verify(entityManager, times(1)).find(Employee.class, 1);
    }

    @Test
    public void testSave() {
        Employee emp = new Employee("John", "Doe", "john.doe@example.com");
        emp.setId(1);

        doNothing().when(entityManager).persist(emp);

        Boolean result = employeeDAO.save(emp);
        assertEquals(Boolean.TRUE, result);

        verify(entityManager, times(1)).persist(emp);
    }

    @Test
    public void testUpdate() {
        Employee emp = new Employee("John", "Doe", "john.doe@example.com");
        emp.setId(1);

        when(entityManager.merge(emp)).thenReturn(emp);

        int result = employeeDAO.update(emp);
        assertEquals(1, result);

        verify(entityManager, times(1)).merge(emp);
    }

    @Test
    public void testDelete() {
        Employee emp = new Employee("John", "Doe", "john.doe@example.com");
        emp.setId(1);

        when(entityManager.contains(emp)).thenReturn(true);
        doNothing().when(entityManager).remove(emp);

        Boolean result = employeeDAO.delete(emp);
        assertEquals(Boolean.TRUE, result);

        verify(entityManager, times(1)).remove(emp);
    }
}
