# 📦 Sistema de Rastreamento de Pacotes

Este projeto é uma aplicação web RESTful desenvolvida com **Spring Boot** que simula o rastreamento de pacotes, incluindo informações de destinatário, endereço e histórico de movimentação (rastreamento). Ele utiliza **JPA/Hibernate** para persistência dos dados em um banco de dados H2 em memória.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- Lombok
- H2 Database (banco de dados em memória)
- Maven

---

## 📌 Funcionalidades

- CRUD completo de **Pacotes**
- CRUD completo de **Endereços**
- Criação e listagem de **Rastreamentos**
- Associação entre entidades:
  - Pacote possui um endereço (`@OneToOne`)
  - Pacote possui vários rastreamentos (`@OneToMany`)

---

## 📁 Estrutura das Entidades

### 🧾 Pacote

- `id`
- `id_pacote`
- `destinatario`
- `status`
- `endereco`: objeto `Endereco`
- `rastreamentos`: lista de objetos `Rastreamento`

### 🗺️ Endereco

- `rua`
- `numero`
- `cidade`
- `estado`
- `cep`

### 📍 Rastreamento

- `data`
- `status`
- `localizacao`

---

## 🔗 Endpoints REST

### 📦 `/pacotes`

- `GET /pacotes` — Lista todos os pacotes
- `GET /pacotes/{id}` — Busca um pacote por ID
- `POST /pacotes` — Cria um novo pacote
- `PUT /pacotes/{id}` — Atualiza um pacote existente
- `DELETE /pacotes/{id}` — Remove um pacote

### 🗺️ `/enderecos`

- `GET /enderecos` — Lista todos os endereços
- `POST /enderecos` — Cria um novo endereço

### 📍 `/rastreamentos`

- `POST /rastreamentos` — Cria um novo rastreamento
- `GET /rastreamentos/{id}` — Lista rastreamentos de um pacote

---

## ▶️ Como Executar

1. Clone o projeto:

```bash
git clone https://github.com/KnowledgeMoor/rastreamento-pacotes-api.git
```

## 🛠 Console do H2

- Acesse o console do banco em: http://localhost:8080/h2-console
- Configuração:
  - JDBC URL: jdbc:h2:mem:testdb
  - User: sa
  - Password: (em branco)
