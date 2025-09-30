package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class UpdateClientService {

    private final ClienteRepository clienteRepository;

    private SaveClientService saveClientService;


    public UpdateClientService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteModel atualizarDados(Long id, String nome, String cpf, String telefone, String email, String endereco, Date dataNascimento){

        ClienteModel cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para o id " + id));

        if (nome != null) cliente.setNome(nome);
        if (cpf != null) cliente.setCpf(cpf);
        if (telefone != null) cliente.setTelefone(telefone);
        if (email != null) cliente.setEmail(email);
        if (endereco != null) cliente.setEndereco(endereco);
        if (dataNascimento != null) cliente.setDataNascimento(dataNascimento);

        return saveClientService.salvarCliente(cliente);
    }



}
