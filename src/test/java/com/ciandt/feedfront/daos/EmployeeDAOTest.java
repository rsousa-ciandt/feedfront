package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.repositories.EmployeeRepository;
import com.ciandt.feedfront.exceptions.ComprimentoInvalidoException;
import com.ciandt.feedfront.model.EmployeeEntity;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// O DAO é resposável pela persistência dos dados
// Com esse mecanismo de persistência (arquivos), não possui responsabilidades de validar regras
public class EmployeeDAOTest {
    private EmployeeEntity employee;
    private EmployeeRepository<EmployeeEntity> employeeDAO;
    private EntityManager entityManager;

    @BeforeEach
    public void setup() throws ComprimentoInvalidoException {
        EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("feedfront");
        entityManager = entityManagerFactory.createEntityManager();

        employeeDAO = new EmployeeDAO();
        employeeDAO.setEntityManager(entityManager);

        employee = new EmployeeEntity("João", "Silveira", "j.silveira@email.com");
        employee.setFeedbackFeitos(List.of());
        employee.setFeedbackRecebidos(List.of());

        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Feedback f where 1 = 1").executeUpdate();
        entityManager.createQuery("delete from Employee e where 1 = 1").executeUpdate();
        entityManager.getTransaction().commit();

        employeeDAO.salvar(employee);
    }

    @AfterEach
    public void closeEntityManager() {
        entityManager.close();
    }

    @Test
    public void listar() {
        List<EmployeeEntity> result = employeeDAO.listar();

        assertFalse(result.isEmpty());
    }

    @Test
    public void buscar() {
        long idInvalido = -1;
        long idValido = employee.getId();

        Optional<EmployeeEntity> vazio = employeeDAO.buscar(idInvalido);
        Optional<EmployeeEntity> preenchido = employeeDAO.buscar(idValido);

        assertTrue(vazio.isEmpty());
        assertTrue(preenchido.isPresent());
        assertEquals(preenchido.get(), employee);
    }

    @Test
    public void salvar() throws ComprimentoInvalidoException {
        EmployeeEntity employeeValido = new EmployeeEntity("Bruno", "Silveira", "b.silveira@email.com");
        EmployeeEntity employeeInvalido = new EmployeeEntity("Jose", "Silveira", "j.silveira@email.com");

        assertDoesNotThrow(() -> employeeDAO.salvar(employeeValido));
        PersistenceException exception = assertThrows(PersistenceException.class, () -> employeeDAO.salvar(employeeInvalido));

        assertTrue(exception.getCause() instanceof ConstraintViolationException);
    }

    @Test
    public void atualizarDados() {
        employee.setNome("mario");
        employee.setEmail("m.silveira@email.com");

        Optional<EmployeeEntity> employeeSalvo = employeeDAO.buscar(employee.getId());

        assertNotEquals(employeeSalvo.get().getNome(), employee.getNome());
        assertNotEquals(employeeSalvo.get().getEmail(), employee.getEmail());

        EmployeeEntity employeAtualizado = employeeDAO.salvar(employee);

        assertEquals(employeAtualizado.getNome(), employee.getNome());
        assertEquals(employeAtualizado.getEmail(), employee.getEmail());
    }

    @Test
    public void apagar() {
        long idInvalido = -1;
        long idValido = employee.getId();

        boolean apagou1 = employeeDAO.apagar(idValido);
        boolean apagou2 = employeeDAO.apagar(idInvalido);

        assertTrue(apagou1);
        assertFalse(apagou2);
    }
}
