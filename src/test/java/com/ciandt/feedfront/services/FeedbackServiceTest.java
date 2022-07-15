package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.employee.Employee;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.excecoes.EntidadeNaoEncontradaException;
import com.ciandt.feedfront.models.Feedback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackServiceTest {

    private Feedback feedback;

    private Employee autor;

    private Employee proprietario;

    private Service<Feedback> service = new FeedbackService();

    @BeforeEach
    public void initEach() {
        try {
            Files.walk(Paths.get("src/main/resources/data/feedback/"))
                    .filter(p -> p.toString().endsWith(".byte"))
                    .forEach(p -> {
                        new File(p.toString()).delete();
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            autor = new Employee("João", "Silveira", "j.silveira@email.com");
            proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");
        } catch (ComprimentoInvalidoException ignored) {}

        feedback = new Feedback(LocalDate.now(),autor,proprietario,"Agradeco muito pelo apoio feito pelo colega!");//construtor 1
        service.salvar(feedback);
    }

    @Test
    public void listar() {
        List<Feedback> lista= service.listar();

        assertDoesNotThrow(() -> service.listar());
        assertFalse(lista.isEmpty());
        assertTrue(lista.contains(feedback));
        assertEquals(1,lista.size());
    }

    @Test
    public void salvar() {
        Feedback feedbackInvalido = new Feedback(LocalDate.now(),null,null,"feedback sem autor e proprietario");
        Feedback feedbackInvalido2 = new Feedback(LocalDate.now(),autor,proprietario,"tt");
        Feedback feedbackValido = new Feedback(LocalDate.now(),autor,proprietario,"O Colega foi muito prestativo e auxiliou nas minhas atividades");

        assertThrows(IllegalArgumentException.class,() -> service.salvar(feedbackInvalido));
        assertThrows(ComprimentoInvalidoException.class,() -> service.salvar(feedbackInvalido2));

        assertDoesNotThrow(() -> service.salvar(feedbackValido));

    }

    @Test
    public void buscar() {
        Feedback feedbackNaoSalvo = new Feedback(LocalDate.now(),autor,proprietario,"tt");

        assertThrows(EntidadeNaoEncontradaException.class, () -> service.buscar(feedbackNaoSalvo.getId()));
        assertDoesNotThrow(() -> service.buscar(feedback.getId()));

    }

}
