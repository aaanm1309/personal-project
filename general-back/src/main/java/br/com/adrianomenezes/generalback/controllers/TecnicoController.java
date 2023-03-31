//package br.com.adrianomenezes.generalback.controllers;
//
//import java.net.URI;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import jakarta.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import br.com.adrianomenezes.generalback.model.Tecnico;
//import br.com.adrianomenezes.generalback.data.vo.v1.TecnicoVO;
//import br.com.adrianomenezes.generalback.services.TecnicoService;
//
//@RestController
//@RequestMapping(value = "/tecnicos")
//public class TecnicoController {
//
//	@Autowired
//	private TecnicoService service;
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<TecnicoVO> findById(@PathVariable Integer id) {
//		Tecnico obj = service.findById(id);
//		return ResponseEntity.ok().body(new TecnicoVO(obj));
//	}
//
//	@GetMapping
//	public ResponseEntity<List<TecnicoVO>> findAll() {
//		List<Tecnico> list = service.findAll();
//		List<TecnicoVO> listDTO = list.stream().map(obj -> new TecnicoVO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@PostMapping
//	public ResponseEntity<TecnicoVO> create(@Valid @RequestBody TecnicoVO objDTO) {
//		Tecnico newObj = service.create(objDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<TecnicoVO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoVO objDTO) {
//		Tecnico obj = service.update(id, objDTO);
//		return ResponseEntity.ok().body(new TecnicoVO(obj));
//	}
//
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<TecnicoVO> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
