package com.crud.DAO;

import com.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        logger.debug("Entering findAll() method");
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        logger.debug("Exiting findAll() method with {} employees", employees.size());
        return employees;
    }

    @Override
    public Employee findById(int id) {
        logger.debug("Entering findById() method with id: {}", id);
        Employee employee = entityManager.find(Employee.class, id);
        logger.debug("Exiting findById() method with employee: {}", employee);
        return employee;
    }

    @Override
    public Boolean save() {
        return null;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public Boolean deleteById() {
        return null;
    }

    @Override
    public Boolean save(Employee employee) {
        logger.debug("Entering save() method with employee: {}", employee);
        entityManager.persist(employee);
        logger.debug("Exiting save() method");
        return Boolean.TRUE;
    }

    @Override
    public int update(Employee employee) {
        logger.debug("Entering update() method with employee: {}", employee);
        entityManager.merge(employee);
        logger.debug("Exiting update() method");
        return 1; // Assuming update is successful
    }

    @Override
    public Boolean deleteByid(int id) {
        return null;
    }

    @Override
    public Boolean delete(Employee employee) {
        logger.debug("Entering delete() method with employee: {}", employee);
        entityManager.remove(entityManager.contains(employee) ? employee : entityManager.merge(employee));
        logger.debug("Exiting delete() method");
        return Boolean.TRUE;
    }
}
