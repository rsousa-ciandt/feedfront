package com.ciandt.feedfront.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "tb_feedback")
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "The description must have 2 or more characteres")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    private String oQueMelhora;

    private String comoMelhora;

    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Employee autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietario_id", nullable = false)
    private Employee proprietario;

    public Feedback(LocalDate data, Employee autor, Employee proprietario, String descricao) {
        this.data = data;
        this.autor = autor;
        this.proprietario = proprietario;
        this.descricao = descricao;
    }

    public Feedback(LocalDate data, Employee autor, Employee proprietario, String descricao, String oQueMelhora, String comoMelhora)  {
        this.data = data;
        this.autor = autor;
        this.proprietario = proprietario;
        this.descricao = descricao;
        this.oQueMelhora = oQueMelhora;
        this.comoMelhora = comoMelhora;
    }




}
