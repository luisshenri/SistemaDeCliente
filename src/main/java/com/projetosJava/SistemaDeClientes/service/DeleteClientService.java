package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;

import java.util.Optional;

public class DeleteClientService {
    private final ClienteRepository clienteRepository;

    public DeleteClientService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Optional<ClienteModel> deletarUsuario(Long id){
        return clienteRepository.deleteById(id);
    }

}
