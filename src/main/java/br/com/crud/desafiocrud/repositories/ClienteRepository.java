package br.com.crud.desafiocrud.repositories;

import br.com.crud.desafiocrud.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly=true)
    Cliente findByEmail(String email);

    @Transactional(readOnly=true)
    Cliente findByCpf(String cpf);
}
