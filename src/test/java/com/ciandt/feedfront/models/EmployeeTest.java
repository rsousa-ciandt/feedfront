package com.ciandt.feedfront.models;

import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    public Employee employee1;

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
