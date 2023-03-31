package br.com.adrianomenezes.generalback.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.adrianomenezes.generalback.model.Technician;
import br.com.adrianomenezes.generalback.data.vo.v1.TechnicianVO;
import br.com.adrianomenezes.generalback.services.TechnicianService;

@RestController
@RequestMapping(value = "/api/technician/v1/")
public class TechnicianController {

	@Autowired
	private TechnicianService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianVO> findById(@PathVariable Long id) {
		TechnicianVO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<TechnicianVO>> findAll() {
		List<TechnicianVO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<TechnicianVO> create(@Valid @RequestBody TechnicianVO objDTO) {
		Technician newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<TechnicianVO> update(@PathVariable Long id, @Valid @RequestBody TechnicianVO objDTO) {
		Technician obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TechnicianVO(obj));
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TechnicianVO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}


















