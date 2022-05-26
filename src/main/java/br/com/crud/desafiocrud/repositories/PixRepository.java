package br.com.crud.desafiocrud.repositories;

import br.com.crud.desafiocrud.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PixRepository extends JpaRepository<Pix, Integer> {

    @Transactional(readOnly=true)
    Pix findByEmail(String email);

    @Transactional(readOnly=true)
    Pix findByCpf(String cpf);
}
