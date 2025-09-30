package com.projetosJava.SistemaDeClientes.repository;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> buscarPorNome(String nome);
    Optional<ClienteModel> buscarPorCpf(String cpf);
    Optional<ClienteModel> buscarPorEmail(String email);
    Optional<ClienteModel> buscarPorTelefone(String telefone);
    void deletarById(Long id);
}
