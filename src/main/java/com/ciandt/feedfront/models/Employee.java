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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Feedback> feedbackFeitos;

    @OneToMany(mappedBy = "proprietario", fetch = FetchType.LAZY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Feedback> getFeedbackFeitos() {
        return feedbackFeitos;
    }

    public List<Feedback> getFeedbackRecebidos() {
        return feedbackRecebidos;
    }

    public void setFeedbackFeitos(List<Feedback> feedbackFeitos) {
        this.feedbackFeitos = feedbackFeitos;
    }

    public void setFeedbackRecebidos(List<Feedback> feedbackRecebidos) {
        this.feedbackRecebidos = feedbackRecebidos;
    }


    @Override
    public String toString() {
        return String.format("%s: \n\t%s %s %s", getId(), nome, sobrenome, email);
    }
}