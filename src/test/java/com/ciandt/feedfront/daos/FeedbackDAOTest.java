package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.repositories.EmployeeRepository;
import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import com.ciandt.feedfront.model.EmployeeEntity;
import com.ciandt.feedfront.model.FeedbackEntity;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// O DAO é resposável pela persistência dos dados
// Com esse mecanismo de persistência (arquivos), não possui responsabilidades de validar regras
public class FeedbackDAOTest {
    private EmployeeEntity autor;
    private EmployeeEntity proprietario;
    private FeedbackEntity feedback;

    private EmployeeRepository<FeedbackEntity> feedbackDAO;
    private EntityManager entityManager;

    @BeforeEach
    public void setup() throws ComprimentoInvalidoException {
        EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("feedfront");
        entityManager = entityManagerFactory.createEntityManager();

        feedbackDAO = new FeedbackDAO();
        feedbackDAO.setEntityManager(entityManager);

        autor = new EmployeeEntity("joao", "silveira", "j.silveira@email.com");
        proprietario = new EmployeeEntity("joao", "bruno", "j.bruno@email.com");

        feedback = new FeedbackEntity(LocalDate.now(), autor, proprietario, "descrição");

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Feedback f where 1 = 1").executeUpdate();
        entityManager.createQuery("delete from Employee e where 1 = 1").executeUpdate();

        entityManager.persist(autor);
        entityManager.persist(proprietario);
        entityManager.getTransaction().commit();

        feedbackDAO.salvar(feedback);
    }

    @AfterEach
    public void closeEntityManager() {
        entityManager.close();
    }

    @Test
    public void listar() {
        List<FeedbackEntity> result = feedbackDAO.listar();

        assertFalse(result.isEmpty());
    }

    @Test
    public void buscar() {
        long idInvalido = -1;
        long idValido = feedback.getId();

        Optional<FeedbackEntity> vazio = feedbackDAO.buscar(idInvalido);
        Optional<FeedbackEntity> preenchido = feedbackDAO.buscar(idValido);

        assertTrue(vazio.isEmpty());
        assertTrue(preenchido.isPresent());
        assertEquals(preenchido.get(), feedback);
    }

    @Test
    public void salvar() throws ComprimentoInvalidoException {
        FeedbackEntity feedbackValido1 = new FeedbackEntity(LocalDate.now(), null, proprietario, "descrição");
        FeedbackEntity feedbackValido2 = new FeedbackEntity(LocalDate.now(), null, proprietario, "descrição", "oque", "como");

        FeedbackEntity feedbackInvalido = new FeedbackEntity(LocalDate.now(), null, null, "descrição");

        assertDoesNotThrow(() -> feedbackDAO.salvar(feedbackValido1));
        assertDoesNotThrow(() -> feedbackDAO.salvar(feedbackValido2));

        PersistenceException exception = assertThrows(PersistenceException.class, () -> feedbackDAO.salvar(feedbackInvalido));

        assertTrue(exception.getCause() instanceof PropertyValueException);
    }
}
