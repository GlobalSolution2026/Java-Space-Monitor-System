# Pedro Gaspar Fernandes Ferrari - RM: 554887 
# Enrico Ricarte Rodrigues - RM: 558571 
# Victor Freire - RM: 556191

# 🚘 Ford System API

Sistema de gerenciamento de funcionários e clientes da Ford desenvolvido com Java e Spring Boot.  
A aplicação permite realizar operações de cadastro, listagem, atualização e remoção de dados através de uma API REST integrada ao MySQL.

# 🧱 Arquitetura do Projeto

```txt
                ┌─────────────────┐
                │    Postman      │
                │ Testes da API   │
                └────────┬────────┘
                         │ HTTP Requests
                         ▼
        ┌────────────────────────────────┐
        │        Spring Boot API         │
        │                                │
        │  ┌──────────────────────────┐  │
        │  │      Controllers         │  │
        │  └──────────────────────────┘  │
        │                                │
        │  ┌──────────────────────────┐  │
        │  │         Domain           │  │
        │  │  Funcionários/Clientes   │  │
        │  └──────────────────────────┘  │
        │                                │
        │  ┌──────────────────────────┐  │
        │  │      Repositories        │  │
        │  └──────────────────────────┘  │
        └──────────────┬─────────────────┘
                       │ JPA / Hibernate
                       ▼
              ┌─────────────────┐
              │      MySQL      │
              │     Database    │
              └─────────────────┘
```

---

# 📚 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Flyway
- Maven
- Postman

---

# ⚙️ Funcionalidades

## 👨‍💼 Funcionários
- Cadastro de funcionários
- Listagem de funcionários
- Atualização de funcionários
- Remoção de funcionários
- Controle de status ativo/inativo
- Associação de cargo

## 👨‍🔧 Clientes
- Cadastro de clientes
- Listagem de clientes
- Atualização de clientes
- Remoção de clientes
- Associação de modelos de veículos Ford

## 📍 Endereço
- Cadastro completo de endereço
- Associação de endereço aos funcionários e clientes
- Validação de UF e CEP

---

# 🧱 Arquitetura do Projeto

```txt
Postman
   ↓
Spring Boot API
   ↓
MySQL Database
```

---

# 🗂️ Estrutura do Projeto

```bash
src
└── main
    ├── java
    │   └── br.com.fiap3espf.spacemonitorsystem
    │       ├── controller
    │       │   ├── ClienteController.java
    │       │   ├── FuncionarioController.java
    │       │   └── HealthCheckController.java
    │       │
    │       ├── domain
    │       │   ├── alerta
    │       │   ├── sensor
    │       │   └── endereco
    │       │
    │       ├── infra
    │       │
    │       └── FordSystemApplication.java
    │
    └── resources
        ├── application.properties
        └── db.migration
```

---

# 🛠️ Configuração do Banco de Dados

## application.properties

```properties
spring.application.name=FordSystem

server.port=8085

spring.datasource.url=jdbc:mysql://localhost:3306/fordsystem
spring.datasource.username=root
spring.datasource.password=fiap

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# 💾 Banco de Dados

## Criar database

```sql
CREATE DATABASE fordsystem;
```

---

# 🔄 Flyway Migration

O projeto utiliza Flyway para versionamento e controle das alterações no banco de dados.

## Localização

```bash
src/main/resources/db.migration
```

---

# 📁 Exemplo de Migrations

```bash
V1__create-table-sensores.sql
V2__create-table-alertas.sql
V3__alter-table-funcionarios-add-column-ativo.sql
V4__alter-table-clientes-add-column-modelo-carro.sql
```

---

# ▶️ Como Executar o Projeto

## 1️⃣ Iniciar o MySQL Server

Certifique-se de que o serviço MySQL esteja ativo.

---

## 2️⃣ Criar o banco de dados

```sql
CREATE DATABASE fordsystem;
```

---

## 3️⃣ Executar a aplicação

Via Maven:

```bash
mvn spring-boot:run
```

Ou execute diretamente pela IDE.

---

# 📡 Endpoints da API

# 👨‍💼 Funcionários

## ➕ Cadastrar Funcionário

```http
POST /funcionarios
```

---

## 📋 Listar Funcionários

```http
GET /funcionarios
```

---

## ✏️ Atualizar Funcionário

```http
PUT /funcionarios
```

---

## ❌ Remover Funcionário

```http
DELETE /funcionarios/{id}
```

---

# 👨‍🔧 Clientes

## ➕ Cadastrar Cliente

```http
POST /clientes
```

---

## 📋 Listar Clientes

```http
GET /clientes
```

---

## ✏️ Atualizar Cliente

```http
PUT /clientes
```

---

## ❌ Remover Cliente

```http
DELETE /clientes/{id}
```

---

# 📌 Exemplo JSON - Funcionário

```json
{
  "nome": "Carlos Henrique",
  "email": "carlos.henrique@ford.com",
  "telefone": "11988887777",
  "cnh": "123456789",
  "cargo": "ENGENHEIRO",
  "endereco": {
    "logradouro": "Avenida Ford",
    "numero": "1000",
    "complemento": "Bloco A",
    "bairro": "Industrial",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "01010-100"
  }
}
```

---

# 📌 Exemplo JSON - Cliente

```json
{
  "nome": "Pedro Ferrari",
  "email": "pedro.ferrari@email.com",
  "telefone": "11977776666",
  "cnh": "987654321",
  "modeloCarro": "MUSTANG",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": "250",
    "complemento": "Apartamento 12",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "04567-120"
  }
}
```

---

# 🚗 Modelos de Carro

## Enum utilizado no sistema

```java
RAPTOR,
BRONCO,
MUSTANG,
RANGER
```

---

# 👨‍💼 Cargos

## Enum utilizado no sistema

```java
ENGENHEIRO,
MECANICO,
GERENTE,
VENDEDOR
```

---

# 🧪 Testes da API

Os testes da API foram realizados utilizando o Postman.

## URL Base

```http
http://localhost:8085
```

---

# 📋 Exemplos de Requisições

## Buscar Funcionários

```http
GET http://localhost:8085/funcionarios
```

---

## Buscar Clientes

```http
GET http://localhost:8085/clientes
```

---

## Remover Cliente

```http
DELETE http://localhost:8085/clientes/1
```

---

# 🧠 Conceitos Utilizados

- REST API
- CRUD
- Spring Boot
- DTOs / Records
- JPA / Hibernate
- Flyway Migration
- MySQL
- Validações com Jakarta Validation
- Arquitetura em camadas
- Integração com banco de dados
- Versionamento de banco

---

# ✅ Status do Projeto

✔️ Projeto finalizado  
✔️ API funcional  
✔️ Integração com MySQL  
✔️ CRUD completo  
✔️ Testes realizados via Postman

---
