package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Salva um employee")
    @PostMapping
    public ResponseEntity<Employee> salvar(@RequestBody Employee employee) throws BusinessException {

        Employee Employee = employeeService.salvar(employee);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(employee);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> listar()  {
        List<Employee> list = employeeService.listar();

        return ResponseEntity.ok().body(list);
    }

    /*

    public ResponseEntity<Employee> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Employee> atualizar (Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }

     */
}