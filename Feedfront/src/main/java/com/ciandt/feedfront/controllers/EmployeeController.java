package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.dto.EmployeeDTO;
import com.ciandt.feedfront.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/employes")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> listar() {
		List<EmployeeDTO> list = employeeService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> buscar(@PathVariable Long id) {
		EmployeeDTO dto = employeeService.buscar(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> salvar(@RequestBody EmployeeDTO dto) {
		dto = employeeService.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {
		employeeService.apagar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> atualizar(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
		dto = employeeService.atualizar(id, dto);
		return ResponseEntity.ok().body(dto);
	}

}