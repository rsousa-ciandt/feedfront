package com.ciandt.feedfront.employee;


import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.excecoes.EmailInvalidoException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    public Employee employee1;
    public Employee employee2;
    @BeforeEach
    public void initEach() throws ComprimentoInvalidoException {
        employee1 = new Employee("Jose", "Silveira", "j.silveira@email.com");
        employee2 = null;
    }

    @Test
    public void salvarEmployeeTest() throws ComprimentoInvalidoException, EmailInvalidoException, ArquivoException, EmployeeNaoEncontradoException {
        employee2 = new Employee("João", "Silveira", "j.silveira@email.com");

        Employee.salvarEmployee(employee1);
        Employee retornoDePesquisa = Employee.buscarEmployee(employee1.getId());

        assertEquals(retornoDePesquisa, employee1);

        Exception emailException = assertThrows(EmailInvalidoException.class, () -> {
           Employee.salvarEmployee(employee2);
        });

        String mensagemEsperada = "E-mail ja cadastrado no repositorio";
        String mensagemRecebida = emailException.getMessage();

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
        employee1 = new Employee("Ze", "Juvenil", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do nome deve ser maior que 2 caracteres.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void sobrenomeDeveTerComprimentoMaiorQueDois() {
        Exception exception = assertThrows(ComprimentoInvalidoException.class, () ->
        employee1 = new Employee("Joao", "ao", "z.juvenil@ciandt.com")
        );

        String mensagemEsperada = "Comprimento do sobrenome deve ser maior que 2 caracteres.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);

    }
}
