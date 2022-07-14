package com.ciandt.feedfront.controller;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.services.EmployeeService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private Service<Employee> service;

    public EmployeeController() {
        throw new NotImplementedException();
    }

    public List<Employee> listar() throws ArquivoException {
        throw new NotImplementedException();
    }

    public Employee buscar(String id) throws BusinessException, ArquivoException {
        throw new NotImplementedException();
    }

    public Employee salvar(Employee employee) throws BusinessException, ArquivoException {
        throw new NotImplementedException();
    }

    public Employee atualizar(Employee employee) throws BusinessException, ArquivoException {
        throw new NotImplementedException();
    }

    public void apagar(String id) throws BusinessException, ArquivoException {
        throw new NotImplementedException();
    }
}
