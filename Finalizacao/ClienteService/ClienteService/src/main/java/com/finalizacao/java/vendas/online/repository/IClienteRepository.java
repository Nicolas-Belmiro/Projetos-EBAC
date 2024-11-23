package com.finalizacao.java.vendas.online.repository;

import java.util.Optional;

import com.finalizacao.java.Oliveira.online.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String> {

    Optional<Cliente> findByCpf(Long cpf);

}