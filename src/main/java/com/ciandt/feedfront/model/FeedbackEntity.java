package com.ciandt.feedfront.model;

import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

//TODO: UTILIZE ANOTAÇÕES DO LOMBOK COMO @ALLARGSCONSTRUTOR E RETIRE O QUE NÃO FOR MAIS NECESSÁRIO COMO O CONSTRUTOR COM TODOS OS ARGUMENTOS. DEIXE SEU CÓDIGO MAIS SUSCINTO.



@Table(name = "Feedback")
public class FeedbackEntity {
    @Column
    private Long id;
    @Column
    private String descricao;
    @Column
    private String oQueMelhora;
    @Column
    private String comoMelhora;
    @Column
    private LocalDate data;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private EmployeeEntity autor;

    @ManyToOne //(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietario_id", nullable = false)
    private EmployeeEntity proprietario;

    public FeedbackEntity() {
    }

    public FeedbackEntity(LocalDate data, EmployeeEntity autor, EmployeeEntity proprietario, String descricao) throws ComprimentoInvalidoException {
        throw new UnsupportedOperationException();
    }

    public FeedbackEntity(LocalDate data, EmployeeEntity autor, EmployeeEntity proprietario, String descricao, String oQueMelhora, String comoMelhora) throws ComprimentoInvalidoException {
        throw new UnsupportedOperationException();
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
