package com.ciandt.feedfront.services;

import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Employee;
import com.ciandt.feedfront.models.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedBackRepository;

    @Override
    public List<Feedback> listar() {
        List<Feedback> list = feedBackRepository.findAll();
        return list;
    }

    @Override
    public Feedback buscar(long id) throws BusinessException {
        Optional<Feedback> obj = feedBackRepository.findById(id);
        Feedback entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return entity;
    }

    @Transactional
    @Override
    public Feedback salvar(Feedback feedback) throws BusinessException, IllegalArgumentException {
        return feedBackRepository.save(feedback);
    }

}
