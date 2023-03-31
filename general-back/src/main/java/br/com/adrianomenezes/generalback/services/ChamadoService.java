//package br.com.adrianomenezes.generalback.services;
//
//import br.com.adrianomenezes.generalback.data.vo.v1.ChamadoVO;
//import br.com.adrianomenezes.generalback.exceptions.ObjectnotFoundException;
//import br.com.adrianomenezes.generalback.model.Chamado;
//import br.com.adrianomenezes.generalback.model.Cliente;
//import br.com.adrianomenezes.generalback.model.Tecnico;
//import br.com.adrianomenezes.generalback.model.enums.Prioridade;
//import br.com.adrianomenezes.generalback.model.enums.Status;
//import br.com.adrianomenezes.generalback.repositories.ChamadoRepository;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ChamadoService {
//
//	@Autowired
//	private ChamadoRepository repository;
//	@Autowired
//	private TecnicoService tecnicoService;
//	@Autowired
//	private ClienteService clienteService;
//
//	public Chamado findById(Integer id) {
//		Optional<Chamado> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
//	}
//
//	public List<Chamado> findAll() {
//		return repository.findAll();
//	}
//
//	public Chamado create(ChamadoVO obj) {
//		return repository.save(newChamado(obj));
//	}
//
//	public Chamado update(Integer id, @Valid ChamadoVO objDTO) {
//		objDTO.setId(id);
//		Chamado oldObj = findById(id);
//		oldObj = newChamado(objDTO);
//		return repository.save(oldObj);
//	}
//
//	private Chamado newChamado(ChamadoVO obj) {
//		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
//		Cliente cliente = clienteService.findById(obj.getCliente());
//
//		Chamado chamado = new Chamado();
//		if(obj.getId() != null) {
//			chamado.setId(obj.getId());
//		}
//
//		if(obj.getStatus().equals(2)) {
//			chamado.setDataFechamento(LocalDate.now());
//		}
//
//		chamado.setTecnico(tecnico);
//		chamado.setCliente(cliente);
//		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
//		chamado.setStatus(Status.toEnum(obj.getStatus()));
//		chamado.setTitulo(obj.getTitulo());
//		chamado.setObservacoes(obj.getObservacoes());
//		return chamado;
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
