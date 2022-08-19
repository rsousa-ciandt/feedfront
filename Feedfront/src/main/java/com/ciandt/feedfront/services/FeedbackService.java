package com.ciandt.feedfront.services;

import com.ciandt.feedfront.dto.FeedbackDTO;
import com.ciandt.feedfront.entities.Employee;
import com.ciandt.feedfront.entities.Feedback;
import com.ciandt.feedfront.repositories.FeedbackRepository;
import com.ciandt.feedfront.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Transactional
	public FeedbackDTO salvar(FeedbackDTO dto) {
		Feedback entity = new Feedback();
		entity.setDescricao(dto.getDescricao());
		entity.setAutor(new Employee(dto.getAutorId(), null, null, null));
		entity.setProprietario(new Employee(dto.getProprietarioId(), null, null, null));
		entity.setoQueMelhora(dto.getoQueMelhora());
		entity.setComoMelhora(dto.getComoMelhora());
		entity.setData(dto.getData());
		entity = feedbackRepository.save(entity);
		return new FeedbackDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<FeedbackDTO> listar(){
		List<Feedback> list = feedbackRepository.findAll(Sort.by("id"));

		return list.stream().map(x -> new FeedbackDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public FeedbackDTO buscar(Long id) {
		Optional<Feedback> obj = feedbackRepository.findById(id);
		Feedback entity = obj.orElseThrow(() -> new ResourceNotFoundException("Sorry, Entity not found !"));
		return new FeedbackDTO(entity);
	}


}
