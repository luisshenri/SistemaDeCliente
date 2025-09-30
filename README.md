# Sistema de Gerenciamento de Clientes

## 🎓 Projeto Acadêmico — Tópicos Avançados II

Este projeto foi desenvolvido como parte da disciplina de **Tópicos Avançados II** da faculdade. O objetivo é criar um sistema completo de gerenciamento de clientes, utilizando boas práticas de desenvolvimento e arquitetura de software.

---

## 📌 Descrição

Sistema CRUD (Create, Read, Update, Delete) para cadastro e gerenciamento de clientes, com foco em qualidade de código, arquitetura limpa e aplicação dos princípios SOLID.

---

## 🎯 Objetivos

- Desenvolver um sistema funcional para gerenciamento de clientes.
- Aplicar o padrão arquitetural **MVC (Model-View-Controller)**.
- Implementar os **princípios SOLID**.
- Adotar boas práticas de programação e organização de código.

---

## 📋 Requisitos

### Funcionais

- Cadastrar, listar, atualizar e excluir clientes.
- Validação de dados (ex: CPF, e-mail, campos obrigatórios).
- Interface intuitiva (CLI ou GUI).

### Técnicos

#### Arquitetura MVC

- **Model**: Representa as entidades e regras de negócio.
- **View**: Interface com o usuário.
- **Controller**: Intermediação entre Model e View.

#### Princípios SOLID

- **SRP** – Princípio da Responsabilidade Única  
- **OCP** – Princípio Aberto/Fechado  
- **LSP** – Princípio da Substituição de Liskov  
- **ISP** – Princípio da Segregação de Interface  
- **DIP** – Princípio da Inversão de Dependência  

#### Boas Práticas

- Código limpo e bem documentado.
- Tratamento adequado de exceções.
- Separação clara de responsabilidades.

---

## 🛠 Tecnologias Utilizadas

- **Linguagem**: Java  
- **Banco de Dados**: MySQL e H2 (para testes)  
- **Framework**: Spring Boot  

---

## 📂 Estrutura do Projeto

SistemaDeCliente/
├── src/
│   ├── controller/     # Camada de controle (Controllers)
│   ├── model/          # Entidades e lógica de negócio
│   ├── view/           # Interface com o usuário (CLI ou GUI)
│   └── repository/     # Acesso a dados (DAO)
├── tests/              # Testes unitários e de integração
├── docs/               # Documentação do projeto
└── README.md           # Este arquivo
