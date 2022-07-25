package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.excecoes.BusinessException;
import com.ciandt.feedfront.models.Feedback;

import java.util.List;

public class FeedbackService implements Service<Feedback> {
    @Override
    public List<Feedback> listar() {
        return null;
    }

    @Override
    public Feedback buscar(String id) throws BusinessException {
        return null;
    }

    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException {
        return null;
    }

    @Override
    public Feedback atualizar(Feedback feedback) throws BusinessException, IllegalArgumentException {
        return null;
    }

    @Override
    public void apagar(String id) throws BusinessException {

    }

    @Override
    public void setDAO(DAO<Feedback> dao) {

    }
}
