package com.projetosJava.SistemaDeClientes.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;



@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id_cliente;

    private String nome;

    @OneToOne
    private String cpf;

    private String email;

    private Date dataNascimento;

    private String endereco;

    private String telefone;

}
