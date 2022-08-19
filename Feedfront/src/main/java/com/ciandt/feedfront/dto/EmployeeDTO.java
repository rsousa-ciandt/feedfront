package com.ciandt.feedfront.dto;

import com.ciandt.feedfront.entities.Employee;
import com.ciandt.feedfront.entities.Feedback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private List<FeedbackDTO> feedbackFeitos = new ArrayList<>();
	private List<FeedbackDTO> feedbackRecebidos= new ArrayList<>();
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String nome, String sobrenome, String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		email = entity.getEmail();
	}

	public EmployeeDTO(Employee entity, List<Feedback> feedbackFeitos, List<Feedback> feedbackRecebidos) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		email = entity.getEmail();
		feedbackFeitos.forEach(feedFeito -> this.feedbackFeitos.add(new FeedbackDTO(feedFeito)));
		feedbackRecebidos.forEach(feedRecebido -> this.feedbackRecebidos.add(new FeedbackDTO(feedRecebido)));
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

	public List<FeedbackDTO> getFeedbackFeitos() {
		return feedbackFeitos;
	}
}
