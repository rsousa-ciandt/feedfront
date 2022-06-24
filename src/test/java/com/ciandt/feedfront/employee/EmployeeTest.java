package com.ciandt.feedfront.employee;


import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTest {

    private Employee employeeTest;

//    @BeforeEach
//    public void setUp(){
//        employeeTest = new Employee("João", "Garcia", "j.garcia@ciandt.com");
//    }

    @Test
    public void testGetEmail() throws ComprimentoInvalidoException {
        employeeTest = new Employee("João", "Garcia", "j.garcia@ciandt.com");
        assertEquals(employeeTest.getEmail(), "j.garcia@ciandt.com");
    }


    @Test
    public void deveTerComprimentoMaiorQueDois() {
        try {
            employeeTest = new Employee("Ze", "Juvenil", "z.juvenil@ciandt.com");
            fail();
        } catch (ComprimentoInvalidoException ex) {
            assertEquals("Comprimento do nome deve ser maior que 2 caracteres.", ex.getMessage());
        }

    }
}
