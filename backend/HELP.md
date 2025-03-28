# Starcatcher API

Bem-vindo à **Starcatcher API**, uma API desenvolvida para fornecer perguntas e respostas sobre astronomia. Este backend foi construído com **Java Spring Boot** e está integrado a um banco de dados **PostgreSQL** (ou **H2** para testes). A seguir, você encontrará uma descrição detalhada das funcionalidades, endpoints, tecnologias e como configurar e executar o projeto.

---

## 🚀 Funcionalidades

### Gerenciamento de perguntas:
- Cadastro automático de perguntas relacionadas à astronomia no banco de dados.
- Suporte para perguntas com múltiplas opções de resposta.
- Verificação de respostas enviadas pelo usuário.

### Endpoints RESTful:
- Obtenção de todas as perguntas.
- Obtenção de 10 perguntas aleatórias.
- Verificação da resposta de uma única pergunta.
- Verificação de respostas de múltiplas perguntas.

### Configuração de CORS:
- Permite requisições de origem cruzada do frontend localizado em `http://localhost:8081`.

### Integração com banco de dados:
- **PostgreSQL** em ambiente de produção.
- **H2 Database** para execução de testes unitários.

---

## 🛠️ Tecnologias e Frameworks

- **Java 23**: Linguagem de programação principal.
- **Spring Boot 3.4.2**:
  - Spring Web: Para criação dos endpoints RESTful.
  - Spring Data JPA: Para integração com o banco de dados.
- **PostgreSQL**: Banco de dados utilizado em produção.
- **H2 Database**: Banco de dados em memória utilizado para testes.
- **Lombok**: Reduz a verbosidade do código, gerando getters, setters e outras utilidades.
- **Maven**: Gerenciador de dependências.
- **Docker e Docker Compose**: Para executar o banco de dados PostgreSQL.

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/example/starcatcher_api/
│   │   ├── config/         # Configuração do CORS e Seeder (inicializador do banco de dados)
│   │   ├── controller/     # Controladores - Pontos de entrada para os endpoints
│   │   ├── model/          # Modelos de dados (entidades do banco de dados)
│   │   ├── repository/     # Repositórios Spring Data JPA
│   │   ├── service/        # Lógica de negócios
│   │   └── StarcatcherApiApplication.java # Classe principal do Spring Boot
│   └── resources/
│       ├── application.properties    # Configuração de produção (PostgreSQL)
│       └── application-test.properties # Configuração para testes (H2 Database)
└── test/
    ├── java/com/example/starcatcher_api/  # Testes unitários
    └── resources/                        # Configurações do banco de dados para testes
```

---

## 🌐 Endpoints da API

### **Base URL**: `/api/questions`

#### 1. Obter todas as perguntas
**GET** `/api/questions`

**Descrição**: Retorna todas as perguntas cadastradas no banco de dados.

**Resposta:**
```json
[
  {
    "id": 1,
    "questionText": "Qual é o maior planeta do Sistema Solar?",
    "correctAnswer": "Júpiter",
    "answers": ["Saturno", "Júpiter", "Marte", "Urano"]
  }
]
```

#### 2. Obter 10 perguntas aleatórias
**GET** `/api/questions/random`

**Descrição**: Retorna 10 perguntas aleatórias do banco de dados.

**Resposta:**
```json
[
  {
    "id": 5,
    "questionText": "Qual é o planeta mais próximo do Sol?",
    "correctAnswer": "Mercúrio",
    "answers": ["Mercúrio", "Vênus", "Terra", "Marte"]
  }
]
```

#### 3. Verificar resposta de uma pergunta
**POST** `/api/questions/{id}/check`

**Descrição**: Verifica se a resposta enviada pelo usuário está correta.

**Parâmetros:**
- `id` (Path Variable): ID da pergunta a ser verificada.
- `userAnswer` (Query Parameter): Resposta enviada pelo usuário.

**Resposta (sucesso):**
```json
{
  "correct": true,
  "correctAnswer": "Júpiter"
}
```

**Resposta (erro):**
```json
{
  "error": "Pergunta não encontrada"
}
```

#### 4. Verificar respostas de múltiplas perguntas
**POST** `/api/questions/check-all`

**Descrição**: Verifica as respostas de múltiplas perguntas enviadas pelo usuário.

**Exemplo de Requisição:**
```json
[
  { "id": 1, "answer": "Júpiter" },
  { "id": 2, "answer": "Marte" }
]
```

**Resposta:**
```json
{
  "correctCount": 2,
  "totalQuestions": 2
}
```

---

## 🛠️ Configuração e Execução

### **Pré-requisitos**
- **Java 23** ou superior.
- **Maven** (opcional, pois o wrapper Maven está incluído no projeto).
- **PostgreSQL** (ou Docker para executar o banco de dados localmente).

### **Configuração do Banco de Dados**

**Produção:**
Atualize o arquivo `src/main/resources/application.properties` com as informações de conexão do banco de dados PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/starcatcher_db
spring.datasource.username=starcatcher
spring.datasource.password=starcatcher
```

**Testes:**
O banco de dados H2 será usado automaticamente para testes. Use o arquivo `src/test/resources/application.properties` para ajustes.

### **Executando Localmente**

**Clone o Repositório:**
```bash
git clone https://github.com/EnzoVieira3012/Starcatcher-PF.git
cd starcatcher_api
```

**Inicie o Banco de Dados com Docker:**
```bash
docker-compose up -d
```

**Execute a Aplicação:**
```bash
./mvnw spring-boot:run
```
Ou diretamente com sua IDE favorita.

**Acesse a API:**
- A aplicação estará disponível em: `http://localhost:8080`.

---

## 🧪 Executando Testes

Para rodar os testes, utilize o Maven:
```bash
./mvnw test
```
O banco de dados em memória H2 será utilizado automaticamente para os testes.

---

## 📖 Licença
Este projeto está licenciado sob a **Apache License 2.0**. Consulte o arquivo `LICENSE` para mais detalhes.
