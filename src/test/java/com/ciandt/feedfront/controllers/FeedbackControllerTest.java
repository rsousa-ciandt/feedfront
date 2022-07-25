package com.ciandt.feedfront.controllers;

//import com.ciandt.feedfront.controllers.FeedbackController;
import com.ciandt.feedfront.controller.EmployeeController;
import com.ciandt.feedfront.controller.FeedbackController;
import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
//import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.utils.LimparRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class FeedbackControllerTest {

    private Feedback feedback;

    private Employee autor;

    private Employee proprietario;

    private FeedbackController controller;
    private EmployeeController employeeController;

    @BeforeEach
    public void initEach() throws IOException, BusinessException {
        LimparRepositorio.limparRepositorio("src/main/resources/data/feedback/");
        LimparRepositorio.limparRepositorio("src/main/resources/data/employee/");

        controller = new FeedbackController();
        employeeController = new EmployeeController();

        autor = new Employee("João", "Silveira", "j.silveira@email.com");
        proprietario = new Employee("Mateus", "Santos", "m.santos@email.com");

        feedback = new Feedback(LocalDate.now(), autor, proprietario,"Agradeco muito pelo apoio feito pelo colega!");//construtor 1

        employeeController.salvar(autor);
        employeeController.salvar(proprietario);

        controller.salvar(feedback);
    }
    @Test
    public void listar() throws ArquivoException {
        Collection<Feedback> listaFeedback = controller.listar();

        assertNotNull(listaFeedback);
    }

    @Test
    public void salvar() {
        assertDoesNotThrow(() -> controller.salvar(feedback));
    }

    @Test
    public void buscar() {
        String uuid = feedback.getId();

        Feedback feedbackSalvo = assertDoesNotThrow(() -> controller.buscar(uuid));

        assertEquals(feedback, feedbackSalvo);

    }

}
