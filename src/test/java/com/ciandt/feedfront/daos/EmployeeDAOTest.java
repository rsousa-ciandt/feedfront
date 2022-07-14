package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmployeeDAOTest {
    private Employee employee;
    private DAO<Employee> dao = new EmployeeDAO();

    @BeforeEach
    public void initEach() {
        try {
            Files.walk(Paths.get("src/main/resources/data/employee/"))
                    .filter(p -> p.toString().endsWith(".byte"))
                    .forEach(p -> {
                        new File(p.toString()).delete();
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            employee = new Employee("João", "Silveira", "j.silveira@email.com");
            dao.salvar(employee);
        } catch (IOException | ComprimentoInvalidoException ignored) {
        }
    }

    @Test
    public void listar() throws IOException {
        List<Employee> result = dao.listar();

        assertFalse(result.isEmpty());
    }

    @Test
    public void buscar() {
        String idValido = employee.getId();
        String idInvalido = UUID.randomUUID().toString();


        assertThrows(IOException.class, () -> dao.buscar(idInvalido));
        Employee employeSalvo = assertDoesNotThrow(() -> dao.buscar(idValido));

        assertEquals(employeSalvo, employee);
    }

    @Test
    public void salvar() throws IOException, ComprimentoInvalidoException {
        String id = employee.getId();
        Employee employeeSalvo = dao.buscar(id);
        Employee employeeNaoSalvo = new Employee("Jose", "Silveira", "j.silveira@email.com");

        assertEquals(employee, employeeSalvo);
        assertDoesNotThrow(() -> dao.salvar(employeeNaoSalvo));
    }

    @Test
    public void atualizarDados() throws IOException, ComprimentoInvalidoException {
        employee.setNome("bruno");
        employee.setEmail("b.silveira@email.com");

        Employee employeeSalvo = dao.buscar(employee.getId());

        assertNotEquals(employeeSalvo.getNome(), employee.getNome());
        assertNotEquals(employeeSalvo.getEmail(), employee.getEmail());

        Employee employeAtualizado = dao.salvar(employee);

        assertEquals(employeAtualizado, employee);
    }

    @Test
    public void apagar() {
        assertDoesNotThrow(() -> dao.salvar(employee));
        assertDoesNotThrow(() -> dao.apagar(employee.getId()));

        assertThrows(IOException.class, () -> dao.buscar(employee.getId()));
    }
}
