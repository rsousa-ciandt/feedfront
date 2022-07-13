package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.excecoes.EntidadeNaoSerializavelException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDAO implements DAO<Employee> {
    private String repositorioPath = "";

    @Override
    public boolean tipoImplementaSerializable() {
        throw new NotImplementedException();
    }

    @Override
    public List<Employee> listar() throws IOException, EntidadeNaoSerializavelException {
        throw new NotImplementedException();
    }

    @Override
    public Employee buscar(String id) throws IOException, EntidadeNaoSerializavelException{
        throw new NotImplementedException();
    }

    @Override
    public Employee salvar(Employee employee) throws IOException, EntidadeNaoSerializavelException {
        throw new NotImplementedException();
    }

    @Override
    public void apagar(String id) throws IOException, EntidadeNaoSerializavelException {
        throw new NotImplementedException();
    }
}
