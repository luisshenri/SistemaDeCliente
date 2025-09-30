package com.projetosJava.SistemaDeClientes.service;

import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class DeleteClientService {
    private final ClienteRepository clienteRepository;

    public DeleteClientService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<ClienteModel> deletarUsuario(Long id){
        try {
            clienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
