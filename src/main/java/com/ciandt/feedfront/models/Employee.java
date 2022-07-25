package com.ciandt.feedfront.models;

import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nome;
    private String sobrenome;
    private String email;

    @OneToMany(mappedBy = "feedback")
    private List<Feedback> feedbackFeitos;

    @OneToMany(mappedBy = "feedback")
    private List<Feedback> feedbackRecebidos;

    public Employee() {
    }

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return String.format("%s %s %s", nome, sobrenome, email);
    }
}