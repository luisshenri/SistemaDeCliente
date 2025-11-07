package com.projetosJava.SistemaDeClientes.service;


import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> listarTudo(){
        return clienteRepository.findAll();
    }

}
