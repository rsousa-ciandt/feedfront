package com.ciandt.feedfront.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name must have 3 or more character")
    @Column (nullable = false)
    private String nome;

    @Size(min = 3, message = "Name musst have 3 or more character")
    @Column (nullable = false)
    private String sobrenome;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private List<Feedback> feedbackFeitos;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietario_id")
    private List<Feedback> feedbackRecebidos;

    public Employee(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }
}