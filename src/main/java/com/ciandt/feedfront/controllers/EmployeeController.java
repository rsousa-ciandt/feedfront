package com.ciandt.feedfront.controllers;

import java.util.List;

//TODO: APLIQUE AS ANOTAÇÕES NECESSÁRIAS PARA QUE O PROGRAMA RECONHEÇA AS DIFERENTES CAMADAS COMO @SERVICE, @RESTCONTROLLER. NÃO ESQUEÇA DAS INJEÇÕES DE DEPENDENCIA COM O @AUTOWIRED
//TODO: APLIQUE AS ANOTAÇÕES DO SWAGGER CONFORME O EXEMPLO @ApiOperation EM FEEDBACKCONTROLLER.

@RequestMapping("/employee")
public class EmployeeController {

   private EmployeeServiceImpl employeeService;

    // Utilize o exemplo de salvar na classe FeedbackController para implementar os métodos:

    public List<Employee> listar()  {
        throw new UnsupportedOperationException();
    }

    public Employee buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public Employee salvar(Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public void apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    public void atualizar (Employee employee) throws BusinessException {
        throw new UnsupportedOperationException();
    }
}