package br.com.adrianomenezes.generalback.services;

import br.com.adrianomenezes.generalback.controllers.TaskController;
import br.com.adrianomenezes.generalback.data.vo.v1.TaskVO;
import br.com.adrianomenezes.generalback.exceptions.DataIntegrityViolationException;
import br.com.adrianomenezes.generalback.exceptions.ResourceNotFoundException;
import br.com.adrianomenezes.generalback.model.Task;
import br.com.adrianomenezes.generalback.model.User;
import br.com.adrianomenezes.generalback.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TaskService {

	private final Logger logger =   Logger.getLogger(TaskService.class.getName());
	@Autowired
	private TaskRepository repository;

	@Autowired
	private UserService userService;

	public TaskVO findById(Long id) {
		logger.info("Finding one Task");
//		System.out.println(user.getPermissions());
		Task obj = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
		var task = new TaskVO(obj);

		task.add(linkTo(methodOn(TaskController.class).findById(id)).withSelfRel());
		return task;
	}

	public TaskVO findByIdAndUser(Long id, User user) {
		logger.info("Finding User");
		User locatedUser =  userService.loadUserById(user.getId());
		logger.info("Finding one Task by User");

		Task obj = repository.findByIdAndUser(id,locatedUser)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id + " and User: " + user.getId()));
		var task = new TaskVO(obj);

		task.add(linkTo(methodOn(TaskController.class).findById(id)).withSelfRel());
		return task;
	}

	public List<TaskVO> findAll() {
		List<Task> list = repository.findAll();
		List<TaskVO> listVO = list.stream().map(TaskVO::new)
				.collect(Collectors.toList());
		listVO.stream()
				.forEach(b -> {
					try {
						b.add(linkTo(methodOn(TaskController.class).findById(b.getKey())).withSelfRel());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		return listVO;
	}

	public List<TaskVO> findAllByUser(User user) {
		logger.info("Finding User");
		User locatedUser =  userService.loadUserById(user.getId());
		logger.info("Finding All Tasks for the User");
		List<Task> list = repository.findAllByUser(locatedUser);
		List<TaskVO> listVO = list.stream().map(TaskVO::new)
				.collect(Collectors.toList());
		listVO.stream()
				.forEach(b -> {
					try {
						b.add(linkTo(methodOn(TaskController.class).findById(b.getKey())).withSelfRel());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		return listVO;
	}


	public TaskVO create(@Valid TaskVO objDTO) {
		objDTO.setKey(null);

		Task newObj = new Task(objDTO);
		try {
			return new TaskVO(repository.save(newObj));
		} catch (Exception e) {
			throw new DataIntegrityViolationException(e.getMessage());

		}
	}

//	public Technician update(Long id, @Valid TechnicianVO objDTO) {
//		objDTO.setKey(id);
//		Technician oldObj = new Technician(findById(id));
//
////		if(!objDTO.getPassword().equals(oldObj.getPassword()))
////			objDTO.setPassword(encoder.encode(objDTO.getPassword()));
//
//		checkByCpfAndEmail(objDTO);
//		oldObj = new Technician(objDTO);
//		return repository.save(oldObj);
//	}
//
	public void delete(Long id) {
        Task obj = new Task(findById(id));
		repository.deleteById(id);
	}

	public void deleteAllyByUser(User user) {
		System.out.println(user.getPermissions());
		repository.deleteAllByUser(user);
	}


	//
//	private void checkByCpfAndEmail(TechnicianVO objDTO) {
//		Optional<Technician> obj = repository.findByCpf(objDTO.getCpf());
//		if (obj.isPresent() && obj.get().getId() != objDTO.getKey()) {
//			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
//		}
//
//		obj = repository.findByEmail(objDTO.getEmail());
//		if (obj.isPresent() && obj.get().getId() != objDTO.getKey()) {
//			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
//		}
//	}

}
