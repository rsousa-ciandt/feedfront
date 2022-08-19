package com.ciandt.feedfront.dto;

import com.ciandt.feedfront.entities.Feedback;

import java.io.Serializable;
import java.time.LocalDate;

public class FeedbackDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private Long autorId;
	private Long proprietarioId;
	private String oQueMelhora;
	private String comoMelhora;
	private LocalDate data;
	
	public FeedbackDTO() {
	}

	public FeedbackDTO(Long id, String descricao, Long autorId, Long proprietarioId, LocalDate data) {
		this.id = id;
		this.descricao = descricao;
		this.autorId = autorId;
		this.proprietarioId = proprietarioId;
		this.data = data;
	}

	public FeedbackDTO(Feedback entity) {
		id = entity.getId();
		descricao = entity.getDescricao();
		autorId = entity.getAutor().getId();
		proprietarioId =entity.getProprietario().getId();
		oQueMelhora = entity.getoQueMelhora();
		comoMelhora = entity.getComoMelhora();
		data = entity.getData();
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

	public Long getAutorId() {
		return autorId;
	}

	public void setAutorId(Long autorId) {
		this.autorId = autorId;
	}

	public Long getProprietarioId() {
		return proprietarioId;
	}

	public void setProprietarioId(Long proprietarioId) {
		this.proprietarioId = proprietarioId;
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
