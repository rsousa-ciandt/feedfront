package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EmployeeDAO implements DAO<Employee> {
    private EntityManager entityManager;

    public EmployeeDAO() {
    }

    @Override
    public List<Employee> listar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee buscar(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee salvar(Employee employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean apagar(long id)  {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
    }
}
