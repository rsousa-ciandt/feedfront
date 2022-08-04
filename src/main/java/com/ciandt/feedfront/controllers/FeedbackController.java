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

    public ResponseEntity<List<Feedback>> listar() {
        throw new UnsupportedOperationException();
    }

    @ApiOperation(value = "Este retorna todos os dados enviados pelos usuários no banco de dados.")
    @GetMapping("/getAll")
    public ResponseEntity<List<Feedback>> findall() {
        List<Feedback> list = feedbackService.findallfeedback();
        return new ResponseEntity<List<Feedback>>(list , HttpStatus.OK);
    }


    public ResponseEntity<Feedback> savefeedback(@RequestBody Feedback feedback) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}
