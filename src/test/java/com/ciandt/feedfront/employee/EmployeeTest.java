package com.ciandt.feedfront.employee;


import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    public Employee employeeTest;
    public Employee empregado1;
    @BeforeEach
    public void initEach() throws ComprimentoInvalidoException {
        employeeTest = new Employee("Jose", "Silveira", "j.silveira@email.com");
    }

    @Test
    public void salvarEmployeeTest() throws ComprimentoInvalidoException, ArquivoException {
        Employee empregado = new Employee("Jose", "Silveira", "j.silveira@email.com");
        employeeTest.salvarEmployee(empregado);
        Employee retornoDePesquisa = employeeTest.buscarEmployee(empregado.getId());
        assertEquals(retornoDePesquisa.getId(), empregado.getId());

        Exception exception = assertThrows(ArquivoException.class, () ->
                empregado1 = new Employee("Joao", "Silveira", "j.silveira@email.com")
                );
        String mensagemEsperada = "E-mail ja cadastrado no repositorio";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);

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
