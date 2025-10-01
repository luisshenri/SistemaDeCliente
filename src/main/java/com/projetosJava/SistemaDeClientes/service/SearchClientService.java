package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SearchClientService {

    private final ClienteRepository clienteRepository;

    public SearchClientService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Optional<ClienteModel> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public Optional<ClienteModel> buscarPorNome(String nome){
        return clienteRepository.findByName(nome);
    }

    public Optional<ClienteModel> buscarPorCpf(String cpf) { return clienteRepository.findByCpf(cpf);}

    public Optional<ClienteModel> buscarPorEmail(String email){
        return clienteRepository.findByEmail(email);
    }

    public Optional<ClienteModel> buscarPorTelefone(String telefone){
        return clienteRepository.findByTelefone(telefone);

    }
}
