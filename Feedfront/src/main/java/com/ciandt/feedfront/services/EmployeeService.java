package com.ciandt.feedfront.services;

import com.ciandt.feedfront.dto.EmployeeDTO;
import com.ciandt.feedfront.entities.Employee;
import com.ciandt.feedfront.repositories.EmployeeRepository;
import com.ciandt.feedfront.services.exceptions.DatabaseException;
import com.ciandt.feedfront.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> listar(){
		List<Employee> list = employeeRepository.findAll(Sort.by("nome"));

		return list.stream().map(x -> new EmployeeDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public EmployeeDTO buscar(Long id) {
		Optional<Employee> obj = employeeRepository.findById(id);
		Employee entity = obj.orElseThrow(() -> new ResourceNotFoundException("Sorry, Entity not found !"));
		return new EmployeeDTO(entity, entity.getFeedbackFeitos(), entity.getFeedbackRecebidos());
	}

	@Transactional
	public EmployeeDTO salvar(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setNome(dto.getNome());
		entity.setSobrenome(dto.getSobrenome());
		entity.setEmail(dto.getEmail());
		entity = employeeRepository.save(entity);
		return new EmployeeDTO(entity);
	}

	public void apagar(Long id) {
		try {
			employeeRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	@Transactional
	public EmployeeDTO atualizar(Long id, EmployeeDTO dto) {
		try {
			Employee entity = employeeRepository.getOne(id);
			entity.setNome(dto.getNome());
			entity.setSobrenome(dto.getSobrenome());
			entity.setEmail(dto.getEmail());
			entity = employeeRepository.save(entity);
			return new EmployeeDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

}
