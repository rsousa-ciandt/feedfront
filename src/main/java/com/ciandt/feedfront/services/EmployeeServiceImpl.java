package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;

import java.util.List;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT
public class EmployeeServiceImpl {

    private EmployeeRepository employeeRepository;

    public Employee salvar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public List<Employee> listaremployee() throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public Employee buscarPorId(Long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public void apagar(Long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }
    // Utilize como exemplo o método atualizar do bloco III
    public Employee atualizar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}