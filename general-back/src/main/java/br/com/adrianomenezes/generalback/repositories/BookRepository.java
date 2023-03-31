package br.com.adrianomenezes.generalback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrianomenezes.generalback.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
