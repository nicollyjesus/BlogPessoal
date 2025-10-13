# 🚀 Projeto Blog Pessoal - Backend com Spring Boot

<div align="center">
  <img src="https://i.imgur.com/w8tTOuT.png" alt="Blog Pessoal Banner" />
</div>

<div align="center">
  <img src="https://img.shields.io/github/languages/top/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/github/repo-size/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/github/languages/count/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/github/last-commit/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/github/issues/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/github/issues-pr/rafaelq80/aulas_java_t82?style=flat-square" />
  <img src="https://img.shields.io/badge/status-em_construção-yellow" />
</div>

---

## 📌 Descrição

O **Blog Pessoal** é uma aplicação backend que permite aos usuários criar, editar e visualizar postagens sobre diversos temas. Desenvolvido com fins educacionais, o projeto simula um blog real para praticar conceitos de API REST com Java e Spring Boot.

### ✨ Funcionalidades principais:

- 📝 CRUD de postagens
- 🗂️ Associação de postagens a temas
- 👤 Cadastro e login de usuários
- 🔍 Filtro por tema ou autor
- 🔐 Controle de acesso com autenticação JWT

---

## ⚙️ Sobre a API

A API foi construída com **Java + Spring Boot**, seguindo os padrões **MVC** e **RESTful**. Os principais recursos são:

- 👥 Usuário
- 📝 Postagem
- 🗂️ Tema

### 🔧 Funcionalidades da API:

- Cadastro, login e atualização de usuários
- Gerenciamento de temas
- CRUD de postagens
- Associação de postagens a temas e autores
- Autenticação via JWT

---

## 📐 Diagrama de Classes

```mermaid
classDiagram
class Postagem {
  - id : Long
  - titulo : String
  - texto : String
  - data : LocalDateTime
  - tema : Tema
  - usuario : Usuario
}
class Tema {
  - id : Long
  - descricao : String
  - postagens : List<Postagem>
}
class Usuario {
  - id : Long
  - nome : String
  - usuario : String
  - senha : String
  - foto : String
  - postagens : List<Postagem>
}
Tema "1" --> "0..*" Postagem : classifica
Usuario "1" --> "0..*" Postagem : cria
```

---

## 🗃️ Diagrama Entidade-Relacionamento (DER)

```mermaid
erDiagram
    tb_usuarios ||--o{ tb_postagens : escreve
    tb_temas ||--o{ tb_postagens : classifica
    tb_usuarios {
        bigint id PK
        varchar(255) nome
        varchar(255) usuario
        varchar(255) senha
        varchar(5000) foto
    }
    tb_temas {
        bigint id PK
        varchar(255) descricao
    }
    tb_postagens {
        bigint id PK
        varchar(255) titulo
        varchar(255) texto
        datetime data
        bigint tema_id FK
        bigint usuario_id FK
    }
```

--- 

## 🛠️ Tecnologias Utilizadas

| 🔧 Tecnologia                 | 💡 Descrição             |
|-----------------------------|--------------------------|
| **Servidor**                | Tomcat                   |
| **Linguagem de Programação**| Java                     |
| **Framework**               | Spring Boot              |
| **ORM**                     | JPA + Hibernate          |
| **Banco de Dados**          | MySQL                    |
| **Segurança**               | Spring Security          |
| **Autenticação**            | JWT                      |
| **Testes Automatizados**    | JUnit                    |
| **Documentação da API**     | SpringDoc (Swagger UI)   |

---

## 📋 Requisitos

1. ☕ Java JDK 17+
2. 🛢️ MySQL
3. 🧰 Spring Tool Suite (STS)
4. 🔍 Insomnia ou Postman

---

## ▶️ Como Executar o Projeto

### 📥 Importando no STS

```text
  git clone https://github.com/rafaelq80/blogpessoal_spring_t82.git
```

### Abra o STS e selecione o Workspace

- Vá em File > Import...
- Escolha General > Existing Projects into Workspace
- Selecione a pasta clonada
- Finalize a importação

### 🚀 Executando

- Vá até a guia Boot Dashboard
- Selecione o projeto
- Clique em Start or Restart
- Verifique se o banco db_blogpessoal foi criado
- Teste os endpoints com Insomnia ou Postman
- 💡 Acesse http://localhost:8080 para visualizar a documentação Swagger da API.
  
---

## ✅ Executando os Testes

- 🔍 Localizando as classes
- Navegue até src/test/java
- Procure por classes com sufixo Test

### 🧪 Executando
- Clique com o botão direito na classe ou pasta
- Selecione Run As > JUnit Test

### 📊 Resultados
Verde = sucesso ✅
- Vermelho = falha ❌
- Veja os detalhes em Failure Trace

---

# 👩‍💻 Desenvolvido por

- Nicolly Jesus
- https://www.linkedin.com/in/nicolly-jesus/
- Data: 2025
