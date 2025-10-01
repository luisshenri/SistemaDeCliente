package com.projetosJava.SistemaDeClientes.repository;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByName(String nome);
    Optional<ClienteModel> findByCpf(String cpf);
    Optional<ClienteModel> findByEmail(String email);
    Optional<ClienteModel> findByTelefone(String telefone);

}
