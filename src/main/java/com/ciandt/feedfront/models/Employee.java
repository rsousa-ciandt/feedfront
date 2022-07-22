package com.ciandt.feedfront.models;

import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.*;
import java.util.UUID;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String sobrenome;
    private String email;

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        this();

        setNome(nome);
        setEmail(email);
        setSobrenome(sobrenome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;

        return getId().equals(employee.getId());
    }

    @Override
    public int hashCode() {
        return 31 * 7 + ((id == null) ?  0 : id.hashCode());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ComprimentoInvalidoException {
        if (nome.length() < 3) {
            throw new ComprimentoInvalidoException("Comprimento do nome deve ser maior que 2 caracteres.");
        }

        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) throws ComprimentoInvalidoException {
        if (sobrenome.length() < 3) {
            throw new ComprimentoInvalidoException("Comprimento do sobrenome deve ser maior que 2 caracteres.");
        }

        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s", nome, sobrenome, email);
    }
}