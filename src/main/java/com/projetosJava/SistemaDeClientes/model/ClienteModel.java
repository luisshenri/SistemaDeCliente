package com.projetosJava.SistemaDeClientes.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;


@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @NotBlank(message = "Nome é obrigatoriO")
    private String name;

    @CPF
    @NotBlank(message = "CPF é obrigatoriO")
    private String cpf;

    @Email
    private String email;

    private Date dataNascimento;

    private String endereco;

    private String telefone;

    public ClienteModel(String name, String cpf, String email, Date dataNascimento, String endereco, String telefone){
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public ClienteModel() {

    }
}
