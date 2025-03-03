📌 API Rest para Controle de Contatos

📖 Sobre o Projeto

Este projeto consiste em uma API Rest desenvolvida em Java com Spring Boot para gerenciar um sistema de cadastro de Pessoas e seus respectivos Contatos. Cada pessoa pode ter múltiplos contatos, e a API oferece operações CRUD completas para ambas as entidades.

📌 Este projeto foi desenvolvido como parte do processo seletivo da Minsait.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot 3.4.2

JPA / Hibernate

Banco de Dados: H2

Swagger (OpenAPI) para documentação

⚙️ Funcionalidades

📌 CRUD de Pessoas:

Criar uma nova Pessoa

Obter Pessoa por ID

Obter Pessoa por ID para mala direta (usando DTO)

Listar todas as Pessoas

Atualizar Pessoa por ID

Deletar Pessoa por ID

📌 CRUD de Contatos:

Adicionar um novo Contato a uma Pessoa

Obter Contato por ID

Listar todos os Contatos de uma Pessoa

Atualizar Contato por ID

Deletar Contato por ID

📡 Endpoints da API

🔹 Pessoa

POST /api/pessoas → Criar uma nova Pessoa

GET /api/pessoas/{id} → Obter Pessoa por ID

GET /api/pessoas/maladireta/{id} → Obter Pessoa para mala direta (DTO)

GET /api/pessoas → Listar todas as Pessoas

PUT /api/pessoas/{id} → Atualizar uma Pessoa

DELETE /api/pessoas/{id} → Remover uma Pessoa

🔹 Contato

POST /api/contatos/ → Adicionar um novo Contato a uma Pessoa

GET /api/contatos/{id} → Obter Contato por ID

GET /api/contatos/pessoa/{idPessoa} → Listar todos os Contatos de uma Pessoa

PUT /api/contatos/{id} → Atualizar um Contato

DELETE /api/contatos/{id} → Remover um Contato

🏗️ Modelagem das Entidades

Pessoa

ID (Único, não nulo)

Nome (Obrigatório)

Endereço (Opcional)

CEP (Opcional)

Cidade (Opcional)

UF (Opcional)

Contato

ID (Único, não nulo)

Tipo de Contato (0 = Telefone, 1 = Celular, 2 = Email)

Contato (Obrigatório)

Relacionamento com Pessoa (OneToMany / ManyToOne)

📌 Como Rodar o Projeto

📦 Pré-requisitos

Antes de começar, você precisa ter instalado:

JDK 17+

Maven

Banco de dados H2

🚀 Rodando a Aplicação

# Clone este repositório
$ git clone [https://github.com/Mendes17/api-controle-de-contatos.git](https://github.com/Mendes17/api-controle-de-contatos.git)

# Acesse a pasta do projeto
$ cd seu-projeto

# Acessar banco de dados H2
JDBC URL: jdbc:h2:mem:controle
User name: sa
Password: (não precisa)

# Compile o projeto
$ mvn clean install

# Execute a aplicação
$ mvn spring-boot:run

A API estará disponível em http://localhost:8080

📜 Documentação com Swagger

Após rodar a aplicação, acesse a documentação interativa no endereço:

http://localhost:8080/swagger-ui.html

✅ Critérios de Avaliação

Cumprimento dos requisitos funcionais

Organização do código

Correta implementação das entidades e relacionamento

Uso adequado do Spring Boot e padrões de design

Documentação com Swagger

Validações e tratamento de dados

Configuração do JPA/Hibernate

API funcional

📩 Contato

Desenvolvido por Henrique Mendes Full Stack Developer🧑‍💻

📧 Email: [henrique.cerqueira.mendes@gmail.com](henrique.cerqueira.mendes@gmail.com) 🔗 LinkedIn: [LinkedIn](www.linkedin.com/in/henrique-cerqueira-mendes-149503270)

