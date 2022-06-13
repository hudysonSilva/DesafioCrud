package br.com.crud.desafiocrud.repositories;

import br.com.crud.desafiocrud.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly=true)
    Cliente findByEmail(String email);

    @Transactional(readOnly=true)
    Cliente findByCpf(String cpf);

    @Query("SELECT obj FROM Cliente obj WHERE obj.cpf LIKE %:cpf% AND obj.senha LIKE %:senha%")
    Optional<Cliente> search(@Param("cpf")String cpf, @Param("senha")String senha);

}
