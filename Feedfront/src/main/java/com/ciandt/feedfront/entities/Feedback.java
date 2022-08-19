package com.ciandt.feedfront.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tb_feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 3, message = "Descricao must have three or more characters")
	@Column(nullable = false)
	private String descricao;

	private String oQueMelhora;

	private String comoMelhora;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Employee autor;

	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Employee proprietario;
	
	public Feedback() {
	}

	public Feedback(LocalDate data, Long id, String descricao, Employee autor, Employee proprietario) {
		this.id = id;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
	}

	public Feedback(Long id, String descricao, Employee autor, Employee proprietario, String oQueMelhora, String comoMelhora, LocalDate data) {
		this.id = id;
		this.descricao = descricao;
		this.autor = autor;
		this.proprietario = proprietario;
		this.oQueMelhora = oQueMelhora;
		this.comoMelhora = comoMelhora;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Employee getAutor() {
		return autor;
	}

	public void setAutor(Employee autor) {
		this.autor = autor;
	}

	public Employee getProprietario() {
		return proprietario;
	}

	public void setProprietario(Employee proprietario) {
		this.proprietario = proprietario;
	}

	public String getoQueMelhora() {
		return oQueMelhora;
	}

	public void setoQueMelhora(String oQueMelhora) {
		this.oQueMelhora = oQueMelhora;
	}

	public String getComoMelhora() {
		return comoMelhora;
	}

	public void setComoMelhora(String comoMelhora) {
		this.comoMelhora = comoMelhora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
