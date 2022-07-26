package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.models.Employee;

import java.util.List;

public class EmployeeDAO implements DAO<Employee> {
    @Override
    public List<Employee> listar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee buscar(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee salvar(Employee employee) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean apagar(String id)  {
        throw new UnsupportedOperationException();
    }
}
