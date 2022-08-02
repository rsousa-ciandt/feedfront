package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.services.Service;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.model.EmployeeEntity;
import com.ciandt.feedfront.model.FeedbackEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.time.LocalDate;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class FeedbackControllerTest {

    private FeedbackEntity feedback;

    private EmployeeEntity autor;

    private EmployeeEntity proprietario;

    private FeedbackController controller;
    private Service<FeedbackEntity> feedbackService;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setup() throws IOException, BusinessException {
        feedbackService = (Service<FeedbackEntity>) Mockito.mock(Service.class);

        controller = new FeedbackController();
        controller.setService(feedbackService);

        autor = new EmployeeEntity("João", "Silveira", "j.silveira@email.com");
        proprietario = new EmployeeEntity("Mateus", "Santos", "m.santos@email.com");

        feedback = new FeedbackEntity(LocalDate.now(), autor, proprietario,"Agradeco muito pelo apoio feito pelo colega!");//construtor 1
        feedback.setId(1L);

        when(feedbackService.salvar(feedback)).thenReturn(feedback);
        controller.salvar(feedback);
    }
    @Test
    public void listar() {
        Collection<FeedbackEntity> listaFeedback = controller.listar();

        assertNotNull(listaFeedback);
    }

    @Test
    public void buscar() throws BusinessException {
        long id = feedback.getId();

        when(feedbackService.buscar(id)).thenReturn(feedback);

        FeedbackEntity feedbackSalvo = assertDoesNotThrow(() -> controller.buscar(id));

        assertEquals(feedback, feedbackSalvo);

    }

    @Test
    public void salvar() throws BusinessException {
        FeedbackEntity novoFeedback = new FeedbackEntity(LocalDate.now(), null, proprietario, "novo");

        when(feedbackService.salvar(novoFeedback)).thenReturn(novoFeedback);

        FeedbackEntity feedbackSalvo = controller.salvar(novoFeedback);

        assertEquals(novoFeedback, feedbackSalvo);
    }

}
