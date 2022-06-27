package com.ciandt.feedfront.employee;


import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    private Employee employeeTest;

    @Test
    public void criarEmployeeTest() {
    }

    @Test
    public void listarEmployees() {
    }

    @Test
    public void buscarEmployee() {
    }

    @Test
    public void apagarEmployee() {
    }

    @Test
    public void atualizarEmployee() {
    }

    @Test
    public void nomeDeveTerComprimentoMaiorQueDois() {
        Exception exception = assertThrows(ComprimentoInvalidoException.class, () ->
        employeeTest = new Employee("Ze", "Juvenil", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do nome deve ser maior que 2 caracteres.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);

    }

    @Test
    public void sobrenomeDeveTerComprimentoMaiorQueDois() {
        Exception exception = assertThrows(ComprimentoInvalidoException.class, () ->
        employeeTest = new Employee("Joao", "ao", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do sobrenome deve ser maior que 2 caracteres.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);

    }
}
