package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.dto.EmployeeDTO;
import com.ciandt.feedfront.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// A função do controller é tratar as solicitações.
// Ser capaz de levar o "pedido" ao "cozinheiro" e me trazer o "prato"

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    private EmployeeDTO employeeDTO;
    private Long existingId;

    @BeforeEach
    void setUp() throws Exception{

        existingId = 1L;

    }

    @Test
    public void deleteShouldReturnNoContentWhenIdExists() throws  Exception {
        ResultActions result = mockMvc.perform(delete("/employes/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNoContent());
    }

}