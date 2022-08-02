package com.ciandt.feedfront.services;



import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.model.FeedbackEntity;
import com.ciandt.feedfront.repositories.FeedBackRepository;

import java.util.List;

//TODO: IMPLEMENTE AS CLASSES E MAPEIE A CLASSE PARA O SPRINGBOOT



public class FeedbackServiceImpl implements FeedbackService {


    private FeedBackRepository feedBackRepository;


    @Override
    public List<FeedbackEntity> listar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FeedbackEntity buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public FeedbackEntity salvar(FeedbackEntity feedback) throws BusinessException, IllegalArgumentException {
       return feedBackRepository.save(feedback) ;
    }

    @Override
    public FeedbackEntity atualizar(FeedbackEntity feedback) throws BusinessException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void apagar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }


}
