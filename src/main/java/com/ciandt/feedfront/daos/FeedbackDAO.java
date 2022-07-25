package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.models.Feedback;

import java.util.List;

public class FeedbackDAO implements DAO<Feedback> {
    @Override
    public boolean tipoImplementaSerializable() {
        return false;
    }

    @Override
    public List<Feedback> listar() {
        return null;
    }

    @Override
    public Feedback buscar(String id){
        return null;
    }

    @Override
    public Feedback salvar(Feedback feedback) {
        return null;
    }

    @Override
    public boolean apagar(String id){
        return false;
    }
}
