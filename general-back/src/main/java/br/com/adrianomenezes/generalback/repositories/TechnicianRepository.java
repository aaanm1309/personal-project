package br.com.adrianomenezes.generalback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianomenezes.generalback.model.Technician;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    Optional<Technician> findByCpf(String cpf);
	Optional<Technician> findByEmail(String email);


}
