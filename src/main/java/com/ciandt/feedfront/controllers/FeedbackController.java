package com.ciandt.feedfront.controllers;


import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.services.FeedbackService;
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
}
