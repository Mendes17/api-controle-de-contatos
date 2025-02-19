# 📌 API Rest para Controle de Contatos

## 📖 Sobre o Projeto
Este projeto consiste em uma API Rest desenvolvida em **Java com Spring Boot** para gerenciar um sistema de **cadastro de Pessoas e seus respectivos Contatos**. Cada pessoa pode ter múltiplos contatos, e a API oferece operações CRUD completas para ambas as entidades.

📌 **Este projeto foi desenvolvido como parte do processo seletivo da empresa Minsait.**  

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.2**
- **JPA / Hibernate**
- **Banco de Dados:** H2 (Banco em memória)
- **Swagger (OpenAPI)** para documentação

## ⚙️ Funcionalidades

### 📌 CRUD de Pessoas:
- Criar uma nova Pessoa
- Obter Pessoa por ID
- Obter Pessoa por ID para mala direta (usando DTO)
- Listar todas as Pessoas
- Atualizar Pessoa por ID
- Deletar Pessoa por ID

### 📌 CRUD de Contatos:
- Adicionar um novo Contato a uma Pessoa
- Obter Contato por ID
- Listar todos os Contatos de uma Pessoa
- Atualizar Contato por ID
- Deletar Contato por ID

## 📡 Endpoints da API

### 🔹 **Pessoa**
- `POST /api/pessoas` → Criar uma nova Pessoa
- `GET /api/pessoas/{id}` → Obter Pessoa por ID
- `GET /api/pessoas/maladireta/{id}` → Obter Pessoa para mala direta (DTO)
- `GET /api/pessoas` → Listar todas as Pessoas
- `PUT /api/pessoas/{id}` → Atualizar uma Pessoa
- `DELETE /api/pessoas/{id}` → Remover uma Pessoa

### 🔹 **Contato**
- `POST /api/contatos` → Adicionar um novo Contato a uma Pessoa
- `GET /api/contatos/{id}` → Obter Contato por ID
- `GET /api/contatos/pessoa/{idPessoa}` → Listar todos os Contatos de uma Pessoa
- `PUT /api/contatos/{id}` → Atualizar um Contato
- `DELETE /api/contatos/{id}` → Remover um Contato

## 🏗️ Modelagem das Entidades

### **Pessoa**
- ID (Único, não nulo)
- Nome (Obrigatório)
- Endereço (Opcional)
- CEP (Opcional)
- Cidade (Opcional)
- UF (Opcional)
- Relacionamento (OneToMany)

### **Contato**
- ID (Único, não nulo)
- Tipo de Contato (TELEFONE, CELULAR, EMAIL)
- Contato (Obrigatório)
- Relacionamento (ManyToOne)

### 🚀 **Rodando a Aplicação**
```bash
# Clone este repositório
$ git clone https://github.com/Mendes17/api-controle-de-contatos.git

Abra o terminal na pasta da api
# Execute a aplicação
$ mvn spring-boot:run

Ou então abra na IDE de sua escolha e execute a aplicação
```

A API estará disponível em `http://localhost:8080`

## 📜 Documentação com Swagger
Após rodar a aplicação, acesse a documentação do Swagger no endereço:
```
http://localhost:8080/swagger-ui.html
```

## 📩 Contato
Desenvolvido por **Henrique Cerqueira Mendes** Full Stack Developer 🧑‍💻

📧 Email: [henrique.cerqueira.mendes@gmail.com](henrique.cerqueira.mendes@gmail.com)
🔗 LinkedIn: [www.linkedin.com/in/henrique-cerqueira-mendes-149503270](www.linkedin.com/in/henrique-cerqueira-mendes-149503270)

