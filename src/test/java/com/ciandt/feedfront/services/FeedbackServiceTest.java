package com.ciandt.feedfront.services;

import com.ciandt.feedfront.repositories.EmployeeRepository;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.EntidadeNaoEncontradaException;
import com.ciandt.feedfront.model.FeedbackEntity;
import com.ciandt.feedfront.model.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class FeedbackServiceTest {
    private EmployeeEntity autor;
    private EmployeeEntity proprietario;

    private FeedbackEntity feedback;

    private EmployeeRepository<FeedbackEntity> feedbackDAO;
    private FeedbackServiceImpl feedbackService;
    private Service<EmployeeEntity> employeeService;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setup() throws BusinessException {
        feedbackDAO = (EmployeeRepository<FeedbackEntity>) Mockito.mock(EmployeeRepository.class);
        employeeService = (Service<EmployeeEntity>) Mockito.mock(Service.class);

        feedbackService = new FeedbackServiceImpl();
        feedbackService.setDAO(feedbackDAO);
        feedbackService.setEmployeeService(employeeService);

        autor = new EmployeeEntity("João", "Silveira", "j.silveira@email.com");
        proprietario = new EmployeeEntity("Mateus", "Santos", "m.santos@email.com");

        feedback = new FeedbackEntity(LocalDate.now(), autor, proprietario, "descrição");

        autor.setId(1L);
        feedback.setId(1L);
        proprietario.setId(2L);

        when(employeeService.buscar(autor.getId())).thenReturn(autor);
        when(employeeService.buscar(autor.getId())).thenReturn(autor);

        feedbackService.salvar(feedback);
    }

    @Test
    public void listar() {
        when(feedbackDAO.listar()).thenReturn(List.of(feedback));

        List<FeedbackEntity> lista = assertDoesNotThrow(() -> feedbackService.listar());

        assertFalse(lista.isEmpty());
        assertTrue(lista.contains(feedback));
        assertEquals(1, lista.size());
    }

    @Test
    public void buscar() {
        long idInvalido = -1;
        long idValido = feedback.getId();

        when(feedbackDAO.buscar(idValido)).thenReturn(Optional.of(feedback));
        when(feedbackDAO.buscar(idInvalido)).thenReturn(Optional.empty());

        assertDoesNotThrow(() -> feedbackService.buscar(feedback.getId()));
        Exception exception = assertThrows(EntidadeNaoEncontradaException.class, () -> feedbackService.buscar(idInvalido));

        assertEquals("não foi possível encontrar o feedback", exception.getMessage());
    }

    @Test
    public void salvar() throws BusinessException {
        EmployeeEntity employeeNaoSalvo = new EmployeeEntity("miguel", "vitor", "m.vitor@email.com");
        employeeNaoSalvo.setId(-1L);

        FeedbackEntity feedbackValido1 = new FeedbackEntity(LocalDate.now(), autor, proprietario, "descrição");
        FeedbackEntity feedbackValido2 = new FeedbackEntity(LocalDate.now(), autor, proprietario, "descrição");

        FeedbackEntity feedbackInvalido1 = new FeedbackEntity(LocalDate.now(), null, null,"feedback sem autor e proprietario");
        FeedbackEntity feedbackInvalido2 = new FeedbackEntity(LocalDate.now(), null, employeeNaoSalvo,"feedback sem autor e proprietario");

        when(feedbackDAO.salvar(feedbackValido1)).thenReturn(feedbackValido1);
        when(feedbackDAO.salvar(feedbackValido2)).thenReturn(feedbackValido2);

        when(employeeService.buscar(employeeNaoSalvo.getId())).thenThrow(new EntidadeNaoEncontradaException("não foi possível encontrar o employee"));

        assertDoesNotThrow(() -> feedbackService.salvar(feedbackValido1));
        assertDoesNotThrow(() -> feedbackService.salvar(feedbackValido2));

        Exception exception1 = assertThrows(IllegalArgumentException.class,() -> feedbackService.salvar(feedbackInvalido1));
        Exception exception2 = assertThrows(IllegalArgumentException.class,() -> feedbackService.salvar(null));
        Exception exception3 = assertThrows(EntidadeNaoEncontradaException.class,() -> feedbackService.salvar(feedbackInvalido2));

        assertEquals("employee inválido", exception1.getMessage());
        assertEquals("feedback inválido", exception2.getMessage());
        assertEquals("não foi possível encontrar o employee", exception3.getMessage());
    }

}
