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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> buscar(@PathVariable Long id) throws BusinessException {
       Employee employee =  employeeService.buscar(id);
       return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity apagar(@PathVariable Long id) throws BusinessException {
        employeeService.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> atualizar(@PathVariable Long id, @RequestBody Employee employee) throws BusinessException {
        employee = employeeService.atualizar(id, employee);
        return ResponseEntity.ok().body(employee);
    }

}