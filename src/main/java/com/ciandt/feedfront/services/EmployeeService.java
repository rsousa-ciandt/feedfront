package com.ciandt.feedfront.services;

import com.feedfront.feedfront.excecoes.BusinessException;
import com.feedfront.feedfront.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listar();

    Employee buscar(long id) throws BusinessException;

    Employee salvar(Employee e) throws BusinessException, IllegalArgumentException;

    Employee atualizar(Employee e) throws BusinessException, IllegalArgumentException;

    void apagar(long id) throws BusinessException;
}
