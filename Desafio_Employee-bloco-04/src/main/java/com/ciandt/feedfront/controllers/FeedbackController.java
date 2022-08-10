package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping
    public ResponseEntity<List<Feedback>> listar() {
        List<Feedback> list = feedbackService.listar();
        return ResponseEntity.ok().body(list);
    }

    public ResponseEntity<Feedback> buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public ResponseEntity<Feedback> salvar(@RequestBody Feedback feedback) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}

