package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.models.Feedback;

import java.util.List;

public class FeedbackDAO implements DAO<Feedback> {
    @Override
    public List<Feedback> listar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Feedback buscar(String id){
        throw new UnsupportedOperationException();
    }

    @Override
    public Feedback salvar(Feedback feedback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean apagar(String id){
        throw new UnsupportedOperationException();
    }
}
