package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackRepository feedBackRepository;

    @Override
    public List<Feedback> listar() {
        List<Feedback> list = feedBackRepository.findAll();
        return list;
    }

    @Override
    public Feedback buscar(long id) throws BusinessException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

}
