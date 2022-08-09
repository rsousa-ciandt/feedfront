package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EmployeeNaoEncontradoException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee salvar(Employee employee) throws BusinessException {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> listar() {
       List<Employee> list = employeeRepository.findAll();
       return list;
    }

    @Override
    public Employee buscar(long id) throws BusinessException {
        Optional<Employee> obj = employeeRepository.findById(id);
        Employee entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return entity;
    }

    @Override
    public void apagar(long id) throws BusinessException {
        try{
            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new BusinessException("Id not found " + id);
        }
    }

    @Override
    public Employee atualizar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }



}