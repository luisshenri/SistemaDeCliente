package com.projetosJava.SistemaDeClientes.controllers;


import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.service.ClienteService;
import com.projetosJava.SistemaDeClientes.service.DeleteClientService;
import com.projetosJava.SistemaDeClientes.service.SaveClientService;
import com.projetosJava.SistemaDeClientes.service.SearchClientService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/")
public class ClienteController {
    private final ClienteService clienteService;

    private final DeleteClientService deleteClientService;

    private final SaveClientService saveClientService;
    private final SearchClientService searchClientService;

    public ClienteController(ClienteService clienteService, DeleteClientService deleteClientService,SearchClientService searchClientService, SaveClientService saveClientService){
        this.clienteService = clienteService;
        this.searchClientService = searchClientService;
        this.saveClientService = saveClientService;
        this.deleteClientService = deleteClientService;
    }


    @GetMapping("/")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarTudo();
    }

    @GetMapping("/editar/{id}")
    public Optional<ClienteModel> buscarClientePorID(long id){
        return searchClientService.buscarPorId(id);
    }

    @PostMapping("/editar/{id}")
    public ClienteModel editarClientePorId(ClienteModel clienteModel){
        return saveClientService.salvarCliente(clienteModel);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<ClienteModel> excluirClientePorID(long id){
        deleteClientService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
