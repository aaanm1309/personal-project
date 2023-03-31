//package br.com.adrianomenezes.generalback.controllers;
//
//import java.net.URI;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
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
//import br.com.adrianomenezes.generalback.model.Cliente;
//import br.com.adrianomenezes.generalback.data.vo.v1.ClienteVO;
//import br.com.adrianomenezes.generalback.services.ClienteService;
//
//@RestController
//@RequestMapping(value = "/clientes")
//public class ClienteController {
//
//	@Autowired
//	private ClienteService service;
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<ClienteVO> findById(@PathVariable Integer id) {
//		Cliente obj = service.findById(id);
//		return ResponseEntity.ok().body(new ClienteVO(obj));
//	}
//
//	@GetMapping
//	public ResponseEntity<List<ClienteVO>> findAll() {
//		List<Cliente> list = service.findAll();
//		List<ClienteVO> listDTO = list.stream().map(obj -> new ClienteVO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
//
//	@PostMapping
//	public ResponseEntity<ClienteVO> create(@Valid @RequestBody ClienteVO objDTO) {
//		Cliente newObj = service.create(objDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<ClienteVO> update(@PathVariable Integer id, @Valid @RequestBody ClienteVO objDTO) {
//		Cliente obj = service.update(id, objDTO);
//		return ResponseEntity.ok().body(new ClienteVO(obj));
//	}
//
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<ClienteVO> delete(@PathVariable Integer id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
//
//}
