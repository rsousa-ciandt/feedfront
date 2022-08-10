package com.ciandt.feedfront.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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

    @JsonFormat(pattern="MM/dd/yyyy")
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Employee autor;

    @ManyToOne
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
