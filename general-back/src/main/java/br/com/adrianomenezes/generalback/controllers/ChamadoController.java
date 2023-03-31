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
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import br.com.adrianomenezes.generalback.model.Chamado;
//import br.com.adrianomenezes.generalback.data.vo.v1.ChamadoVO;
//import br.com.adrianomenezes.generalback.services.ChamadoService;
//
//@RestController
//@RequestMapping(value = "/chamados")
//public class ChamadoController {
//
//	@Autowired
//	private ChamadoService service;
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<ChamadoVO> findById(@PathVariable Integer id) {
//		Chamado obj = service.findById(id);
//		return ResponseEntity.ok().body(new ChamadoVO(obj));
//	}
//
//	@GetMapping
//	public ResponseEntity<List<ChamadoVO>> findAll() {
//		List<Chamado> list = service.findAll();
//		List<ChamadoVO> listDTO = list.stream().map(obj -> new ChamadoVO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
//
//	@PostMapping
//	public ResponseEntity<ChamadoVO> create(@Valid @RequestBody ChamadoVO obj) {
//		Chamado newObj = service.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<ChamadoVO> update(@PathVariable Integer id, @Valid @RequestBody ChamadoVO objDTO) {
//		Chamado newObj = service.update(id, objDTO);
//		return ResponseEntity.ok().body(new ChamadoVO(newObj));
//	}
//}
