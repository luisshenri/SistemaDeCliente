package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SaveClientService {

    private final ClienteRepository clienteRepository;

    public SaveClientService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    public ClienteModel salvarCliente(ClienteModel clienteModel) {
        if (clienteRepository.findByCpf(clienteModel.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> salvarTodosCliente(List<ClienteModel> clienteModel){
        return clienteRepository.saveAll(clienteModel);
    }




}
