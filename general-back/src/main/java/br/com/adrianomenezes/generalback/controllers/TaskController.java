package br.com.adrianomenezes.generalback.controllers;

import br.com.adrianomenezes.generalback.data.vo.v1.TaskMinVO;
import br.com.adrianomenezes.generalback.data.vo.v1.TaskVO;
import br.com.adrianomenezes.generalback.data.vo.v1.TechnicianVO;
import br.com.adrianomenezes.generalback.model.Task;
import br.com.adrianomenezes.generalback.model.Technician;
import br.com.adrianomenezes.generalback.model.User;
import br.com.adrianomenezes.generalback.services.TaskService;
import br.com.adrianomenezes.generalback.services.TechnicianService;
import br.com.adrianomenezes.generalback.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/task/v1/")
public class TaskController {

	@Autowired
	private TaskService service;


	@GetMapping(value = "/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<TaskVO> findById(@PathVariable Long id) {
		TaskVO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<List<TaskVO>> findAll() {
		List<TaskVO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}/user/{userId}")
	public ResponseEntity<TaskVO> findByIdByUser(@PathVariable Long id, @PathVariable Long userId) {
		User user = new User(userId);
		TaskVO obj = service.findByIdAndUser(id, user);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<TaskVO>> findAllByUser(@PathVariable Long userId) {
		User user = new User(userId);
		List<TaskVO> listDTO = service.findAllByUser(user);
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/user/{userId}/min")
	public ResponseEntity<List<TaskMinVO>> findAllByUserMin(@PathVariable Long userId) {
		User user = new User(userId);
		List<TaskVO> listDTO = service.findAllByUser(user);
		List<TaskMinVO> listMinDTO = new ArrayList<>();

		listDTO.stream().forEach(x -> listMinDTO.add(new TaskMinVO(x)) );
		return ResponseEntity.ok().body(listMinDTO);
	}


	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<TaskVO> create(@Valid @RequestBody TaskVO objDTO) {
		TaskVO newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getKey()).toUri();
		return ResponseEntity.created(uri).build();
	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<TechnicianVO> update(@PathVariable Long id, @Valid @RequestBody TechnicianVO objDTO) {
//		Technician obj = service.update(id, objDTO);
//		return ResponseEntity.ok().body(new TechnicianVO(obj));
//	}
//
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TaskVO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<TaskVO> deleteAllByUser(@PathVariable Long userId) {
		User user = new User(userId);
		service.deleteAllyByUser(user);
		return ResponseEntity.noContent().build();
	}

}


















