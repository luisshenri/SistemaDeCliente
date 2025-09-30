package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;

public class SaveClientService {

    private final ClienteRepository clienteRepository;

    public SaveClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel salvarCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }
}
