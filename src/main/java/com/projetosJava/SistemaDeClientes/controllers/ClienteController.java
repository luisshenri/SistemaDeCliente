package com.projetosJava.SistemaDeClientes.controllers;


import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.service.ClienteService;
import com.projetosJava.SistemaDeClientes.service.SaveClientService;
import com.projetosJava.SistemaDeClientes.service.SearchClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/")
public class ClienteController {
    private ClienteService clienteService;

    private SaveClientService saveClientService;
    private SearchClientService searchClientService;

    public ClienteController(ClienteService clienteService, SearchClientService searchClientService, SaveClientService saveClientService){
        this.clienteService = clienteService;
        this.searchClientService = searchClientService;
        this.saveClientService = saveClientService;
    }


    @GetMapping("/")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarTudo();
    }

    @GetMapping("/editar/:id")
    public Optional<ClienteModel> buscarClientePorID(long id){
        return searchClientService.buscarPorId(id);
    }

    @PostMapping("/editar/:id")
    public ClienteModel editarClientePorId(ClienteModel clienteModel){
        return saveClientService.salvarCliente(clienteModel);
    }





}
