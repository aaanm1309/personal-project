package br.com.adrianomenezes.generalback.repositories;

import br.com.adrianomenezes.generalback.model.Task;
import br.com.adrianomenezes.generalback.model.Technician;
import br.com.adrianomenezes.generalback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByIdAndUser(Long id, User user);
    List<Task> findAllByUser(User user);

    void deleteAllByUser(User user);
}
