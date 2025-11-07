package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class UpdateClientService {

    private final ClienteRepository clienteRepository;

    private SaveClientService saveClientService;


    public UpdateClientService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel atualizarDados(Long id, ClienteModel clienteModel){

        return clienteRepository.findById(id).map(cliente -> {
                    cliente.setName(clienteModel.getName());
                    cliente.setCpf(clienteModel.getCpf());
                    cliente.setEmail(clienteModel.getEmail());
                    cliente.setDataNascimento(clienteModel.getDataNascimento());
                    cliente.setEndereco(clienteModel.getEndereco());
                    cliente.setTelefone(clienteModel.getTelefone());
                    return clienteRepository.save(cliente);
        }).orElseThrow(
                () -> new EntityNotFoundException
                        ("Cliente não encontrado para o id " + id)
        );



    }



}
