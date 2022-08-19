package com.ciandt.feedfront.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, message = "Nome must have three or more characters")
	@Column(nullable = false)
	private String nome;

	@Size(min = 3, message = "Sobrenome must have three or more characters")
	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false, unique = true)
	@Email(message = "This email already exists")
	private String email;

	@OneToMany(mappedBy = "autor")
	private List<Feedback> feedbackFeitos = new ArrayList<>();

	@OneToMany(mappedBy = "proprietario")
	private List<Feedback> feedbackRecebidos = new ArrayList<>();
	
	public Employee() {
	}

	public Employee(Long id, String nome, String sobrenome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
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
}
