package com.projetosJava.SistemaDeClientes.controllers;


import com.projetosJava.SistemaDeClientes.model.ClienteModel;
import com.projetosJava.SistemaDeClientes.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController()
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
    private final ClienteService clienteService;

    private final DeleteClientService deleteClientService;

    private final SaveClientService saveClientService;
    private final SearchClientService searchClientService;

    private final UpdateClientService updateClientService;

    public ClienteController(ClienteService clienteService, UpdateClientService updateClientService, DeleteClientService deleteClientService,SearchClientService searchClientService, SaveClientService saveClientService){
        this.clienteService = clienteService;
        this.searchClientService = searchClientService;
        this.saveClientService = saveClientService;
        this.deleteClientService = deleteClientService;
        this.updateClientService = updateClientService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarClientes(){
        return ResponseEntity.ok(clienteService.listarTudo());
    }

    @PostMapping("/novo")
    public ResponseEntity<ClienteModel> novoForm(@RequestBody ClienteModel clienteModel){
        try{
            return ResponseEntity.ok(saveClientService.salvarCliente(clienteModel));
        }catch (Exception e){
            System.out.printf("Não foi possível criar o usuário: %s%n", e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<ClienteModel> editarClientePorId(@PathVariable Long id, @RequestBody ClienteModel clienteModel){
        try {
            return ResponseEntity.ok(updateClientService.atualizarDados(id, clienteModel));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id){
        deleteClientService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<ClienteModel> detalhesCliente(@PathVariable Long id){
        return searchClientService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }


}
