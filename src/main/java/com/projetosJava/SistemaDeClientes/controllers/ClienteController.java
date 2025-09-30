package com.projetosJava.SistemaDeClientes.controllers;


import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.service.ClienteService;
import com.projetosJava.SistemaDeClientes.service.SearchClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/")
public class ClienteController {
    private ClienteService clienteService;

    private SearchClientService searchClientService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    public ClienteController(ClienteService clienteService, SearchClientService searchClientService){
        this.clienteService = clienteService;
        this.searchClientService = searchClientService;
    }


    @GetMapping("/")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarTudo();
    }



}
