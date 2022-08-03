package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> listar();

    Feedback buscar(long id) throws BusinessException;

    Feedback salvar(Feedback e) throws BusinessException, IllegalArgumentException;

    Feedback atualizar(Feedback e) throws BusinessException, IllegalArgumentException;

    void apagar(long id) throws BusinessException;


}