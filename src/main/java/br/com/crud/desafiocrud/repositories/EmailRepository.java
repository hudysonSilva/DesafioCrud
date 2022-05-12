package br.com.crud.desafiocrud.repositories;


import br.com.crud.desafiocrud.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
