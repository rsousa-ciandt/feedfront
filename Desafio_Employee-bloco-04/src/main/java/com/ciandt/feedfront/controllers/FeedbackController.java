package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Feedback> buscar(@PathVariable Long id) throws BusinessException {
        Feedback feedback =  feedbackService.buscar(id);
        return ResponseEntity.ok().body(feedback);
    }

    @PostMapping
    public ResponseEntity<Feedback> salvar(@RequestBody Feedback feedback) throws BusinessException {
        Feedback feedback1 = feedbackService.salvar(feedback);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(feedback.getId()).toUri();
        return ResponseEntity.created(uri).body(feedback);
    }
}

