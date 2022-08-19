package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.dto.FeedbackDTO;
import com.ciandt.feedfront.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping
	public ResponseEntity<FeedbackDTO> salvar(@RequestBody FeedbackDTO dto) {
		dto = feedbackService.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<FeedbackDTO>> listar() {
		List<FeedbackDTO> list = feedbackService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FeedbackDTO> buscar(@PathVariable Long id) {
		FeedbackDTO dto = feedbackService.buscar(id);
		return ResponseEntity.ok().body(dto);
	}

}
