package com.ciandt.feedfront.employee;

import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;

import java.util.List;
import java.util.UUID;

public class Employee {
    private String id;
    private String nome;
    private String sobrenome;
    private String email;

    String arquivoCriado = "arquivo.extensao"; //TODO: alterar de acordo com a sua implementação

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        this.id = UUID.randomUUID().toString();
    }

    public Employee criarEmployee(Employee employee) throws ArquivoException, ComprimentoInvalidoException {
        return null;
    }

    public Employee atualizarEmployee(Employee employee) throws ArquivoException, ComprimentoInvalidoException {
        return null;
    }

    public List<Employee> listarEmployees() throws ArquivoException {
        return null;
    }

    public Employee buscarEmployee() throws ArquivoException, EmployeeNaoEncontradoException {
        return null;
    }

    public void apagarEmployee() throws ArquivoException, EmployeeNaoEncontradoException {
    }

    public String getNome() {
        return null;
    }

    public void setNome(String nome) throws ComprimentoInvalidoException {
    }

    public String getSobrenome() {
        return null;
    }

    public void setSobrenome(String sobrenome) throws ComprimentoInvalidoException {
    }

    public String getEmail() {
        return null;
    }

    public void setEmail(String email) {
    }

    @Override
    public String toString() {
        return email;
    }
}
