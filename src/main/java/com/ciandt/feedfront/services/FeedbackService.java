package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.model.FeedbackEntity;

import java.util.List;

public interface FeedbackService {
    List<FeedbackEntity> listar();

    FeedbackEntity buscar(long id) throws BusinessException;

    FeedbackEntity salvar(FeedbackEntity e) throws BusinessException, IllegalArgumentException;

    FeedbackEntity atualizar(FeedbackEntity e) throws BusinessException, IllegalArgumentException;

    void apagar(long id) throws BusinessException;


}