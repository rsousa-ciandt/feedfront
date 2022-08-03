package com.ciandt.feedfront.controllers;


import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation

@RequestMapping("/v1/feedback")

public class FeedbackController {


    private FeedbackService feedbackService;

    public List<Feedback> listar() {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Feedback> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }


    @ApiOperation(value = "Este salva os dados enviados pelo usuário no banco de dados.")
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback savefeedback(@RequestBody Feedback feedback) throws BusinessException {
        return feedbackService.salvar(feedback);
    }



    public ResponseEntity<Feedback> atualizar(Feedback feedback) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public void apagar(String id) throws BusinessException {
        throw new UnsupportedOperationException();
    }



}
