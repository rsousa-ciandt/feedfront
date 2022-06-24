package com.ciandt.feedfront.employee;

import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;

public class Employee {
    private String nome;
    private String sobrenome;
    private String email;

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        setNome(nome);
        this.sobrenome = sobrenome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ComprimentoInvalidoException {
        if (nome.length() < 3) {
            throw new ComprimentoInvalidoException("Comprimento do nome deve ser maior que 2 caracteres.");
        } else {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
