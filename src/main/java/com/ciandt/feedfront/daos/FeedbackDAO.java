package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.excecoes.EntidadeNaoSerializavelException;
import com.ciandt.feedfront.models.Feedback;

import java.io.IOException;
import java.util.List;

public class FeedbackDAO implements DAO<Feedback> {
    @Override
    public boolean tipoImplementaSerializable() {
        return false;
    }

    @Override
    public List<Feedback> listar() throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public Feedback buscar(String id) throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public Feedback salvar(Feedback feedback) throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public boolean apagar(String id) throws IOException, EntidadeNaoSerializavelException {
        return false;
    }
}
