package com.ciandt.feedfront.models;


import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.excecoes.EmailInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeedbackTest {

    public Feedback feedback1;
    public Feedback feedback2;
    @BeforeEach
    public void initEach() throws IOException, ComprimentoInvalidoException, EmailInvalidoException {
        feedback1 = new Employee("Jose", "Silveira", "j.silveira@email.com");
        feedback2 = null;
    }




    @Test
    public void nomeDeveTerComprimentoMaiorQueDois() {
        Exception comprimentoInvalidoException = assertThrows(ComprimentoInvalidoException.class, () ->
                employee1 = new Employee("Ze", "Juvenil", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do nome deve ser maior que 2 caracteres.";
        String mensagemRecebida = comprimentoInvalidoException.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void sobrenomeDeveTerComprimentoMaiorQueDois() {
        Exception comprimentoInvalidoException = assertThrows(ComprimentoInvalidoException.class, () ->
                employee1 = new Employee("Joao", "ao", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do sobrenome deve ser maior que 2 caracteres.";
        String mensagemRecebida = comprimentoInvalidoException.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);

    }
}
