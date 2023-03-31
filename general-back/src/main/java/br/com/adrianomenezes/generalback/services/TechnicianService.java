package br.com.adrianomenezes.generalback.services;//package br.com.adrianomenezes.generalback.services;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import br.com.adrianomenezes.generalback.controllers.BookController;
import br.com.adrianomenezes.generalback.controllers.TechnicianController;
import br.com.adrianomenezes.generalback.data.vo.v1.BookVO;
import br.com.adrianomenezes.generalback.data.vo.v1.TechnicianVO;
import br.com.adrianomenezes.generalback.exceptions.ResourceNotFoundException;
import br.com.adrianomenezes.generalback.mapper.ModelMapperImpl;
import br.com.adrianomenezes.generalback.model.Book;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.adrianomenezes.generalback.model.Technician;
//import br.com.adrianomenezes.generalback.data.vo.v1.TecnicoVO;
//import br.com.adrianomenezes.generalback.repositories.PessoaRepository;
import br.com.adrianomenezes.generalback.repositories.TechnicianRepository;
import br.com.adrianomenezes.generalback.exceptions.DataIntegrityViolationException;
import br.com.adrianomenezes.generalback.exceptions.ObjectnotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TechnicianService {

	private Logger logger =   Logger.getLogger(TechnicianService.class.getName());
	@Autowired
	private TechnicianRepository repository;
//	@Autowired
//	private PessoaRepository pessoaRepository;
//	@Autowired
//	private BCryptPasswordEncoder encoder;

	public TechnicianVO findById(Long id) {
		logger.info("Finding one Technician");
		Technician obj = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
		var tec = new TechnicianVO(obj);

		tec.add(linkTo(methodOn(TechnicianController.class).findById(id)).withSelfRel());
		return tec;
	}

	public List<TechnicianVO> findAll() {
		List<Technician> list = repository.findAll();
		List<TechnicianVO> listVO = list.stream().map(obj -> new TechnicianVO(obj))
				.collect(Collectors.toList());
		listVO.stream()
				.forEach(b -> {
					try {
						b.add(linkTo(methodOn(TechnicianController.class).findById(b.getKey())).withSelfRel());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		return listVO;
	}

	public Technician create(@Valid TechnicianVO objDTO) {
		objDTO.setKey(null);
//		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		checkByCpfAndEmail(objDTO);
		Technician newObj = new Technician(objDTO);
		try {
			return repository.save(newObj);
		} catch (Exception e) {
			throw new DataIntegrityViolationException(e.getMessage());

		}
	}

	public Technician update(Long id, @Valid TechnicianVO objDTO) {
		objDTO.setKey(id);
		Technician oldObj = new Technician(findById(id));

//		if(!objDTO.getPassword().equals(oldObj.getPassword()))
//			objDTO.setPassword(encoder.encode(objDTO.getPassword()));

		checkByCpfAndEmail(objDTO);
		oldObj = new Technician(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Long id) {
        Technician obj = new Technician(findById(id));

//		if (obj.getChamados().size() > 0) {
//			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
//		}

		repository.deleteById(id);
	}

	private void checkByCpfAndEmail(TechnicianVO objDTO) {
		Optional<Technician> obj = repository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getKey()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}

		obj = repository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getKey()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
