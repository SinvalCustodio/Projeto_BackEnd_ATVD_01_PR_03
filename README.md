# 🎯 Marketplace API - Spring Boot REST

Uma API REST completa para um marketplace de e-commerce, desenvolvida com **Spring Boot 3.0+**, **Spring Data JPA**, **H2 Database** e documentada com **Swagger/OpenAPI 3.0**.

---

## 📋 Sumário

- [Estrutura do Projeto](#📁-estrutura-do-projeto)
- [Endpoints Disponíveis](#🔌-endpoints-disponíveis)
- [Como Iniciar](#🚀-como-iniciar)
- [Documentação](#📚-documentação)
- [Exemplos de Uso](#🧪-exemplos-de-uso)
- [Tecnologias](#⚙️-tecnologias)

---

## 📁 Estrutura do Projeto

```
CRUD/
├── src/main/java/com/example/marketplace/
│   ├── config/
│   │   ├── application.properties    # Configurações da aplicação
│   │   └── SwaggerConfig.java        # Configuração do Swagger/OpenAPI
│   ├── controller/
│   │   ├── UsuarioController.java    # Endpoints de usuários
│   │   └── ProdutoController.java    # Endpoints de produtos
│   ├── service/
│   │   ├── UsuarioService.java       # Lógica de negócio de usuários
│   │   └── ProdutoService.java       # Lógica de negócio de produtos
│   ├── dto/
│   │   ├── UsuarioRequestDTO.java
│   │   ├── UsuarioResponseDTO.java
│   │   ├── ProdutoRequestDTO.java
│   │   └── ProdutoResponseDTO.java
│   ├── model/
│   │   ├── Usuario.java              # Entidade de usuário
│   │   ├── Produto.java              # Entidade de produto
│   │   └── MarketplaceApplication.java  # Classe principal
│   ├── repository/
│   │   ├── UsuarioRepository.java    # Acesso a dados
│   │   └── ProdutoRepository.java    # Acesso a dados
│   └── exception/
│       ├── GlobalExceptionHandler.java
│       └── ResourceNotFoundException.java
├── pom.xml                            # Dependências Maven
└── docs/
    ├── API_ENDPOINTS.md               # Documentação de endpoints
    ├── GUIA_INICIACAO.md              # Guia de inicio rápido
    ├── DEPENDENCIAS_MAVEN.md          # Dependências necessárias
    ├── VALIDACOES_REGRAS.md           # Regras de negócio
    └── EXEMPLOS_REQUISICOES.md        # Exemplos de requisições
```

---

## 🔌 Endpoints Disponíveis

### 👥 Usuários (`/api/usuarios`)

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/api/usuarios` | Listar todos os usuários |
| `GET` | `/api/usuarios/{id}` | Buscar usuário por ID |
| `POST` | `/api/usuarios` | Criar novo usuário |
| `PUT` | `/api/usuarios/{id}` | Atualizar usuário |
| `DELETE` | `/api/usuarios/{id}` | Deletar usuário |

### 📦 Produtos (`/api/produtos`)

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/api/produtos` | Listar todos os produtos |
| `GET` | `/api/produtos/{id}` | Buscar produto por ID |
| `POST` | `/api/produtos` | Criar novo produto |
| `PUT` | `/api/produtos/{id}` | Atualizar produto |
| `DELETE` | `/api/produtos/{id}` | Deletar produto |
| `GET` | `/api/produtos/vendedor/{vendedorId}` | Listar produtos de um vendedor |

---

## 🚀 Como Iniciar

### ✅ Pré-requisitos

- Java 17+
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse ou VS Code)

### 📝 Passos

1. **Instalar dependências**

```bash
mvn clean install
```

2. **Executar a aplicação**

```bash
mvn spring-boot:run
```

3. **Acessar o Swagger**

```
http://localhost:8080/swagger-ui.html
```

---

## 📚 Documentação

### 📖 Guias Disponíveis

| Arquivo | Descrição |
|---------|-----------|
| [GUIA_INICIACAO.md](docs/GUIA_INICIACAO.md) | ⭐ **COMECE AQUI** - Passo a passo para rodar a aplicação |
| [API_ENDPOINTS.md](docs/API_ENDPOINTS.md) | 📌 Lista completa de endpoints com exemplos |
| [EXEMPLOS_REQUISICOES.md](docs/EXEMPLOS_REQUISICOES.md) | 🧪 Exemplos em cURL, Postman, JavaScript e Python |
| [VALIDACOES_REGRAS.md](docs/VALIDACOES_REGRAS.md) | ✔️ Regras de validação e negócio |
| [DEPENDENCIAS_MAVEN.md](docs/DEPENDENCIAS_MAVEN.md) | 📦 Dependências e como adicionar ao pom.xml |

---

## 🧪 Exemplos de Uso

### cURL

#### Criar usuário
```bash
curl -X POST "http://localhost:8080/api/usuarios" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@example.com",
    "senha": "123456"
  }'
```

#### Criar produto
```bash
curl -X POST "http://localhost:8080/api/produtos" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook",
    "descricao": "Notebook de alta performance",
    "preco": 3500.00,
    "quantidadeEstoque": 10,
    "vendedorId": 1
  }'
```

### JavaScript Fetch

```javascript
// Criar usuário
fetch('http://localhost:8080/api/usuarios', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    nome: 'João Silva',
    email: 'joao@example.com',
    senha: '123456'
  })
})
.then(res => res.json())
.then(data => console.log(data));
```

---

## ⚙️ Tecnologias

### Backend
- **Spring Boot** 3.2.0
- **Spring Data JPA** - ORM para acesso a dados
- **Spring Web** - REST APIs
- **Jakarta Validation** - Validações
- **H2 Database** - Banco de dados em memória
- **Lombok** - Redução de boilerplate (opcional)

### Documentação & Testes
- **SpringDoc OpenAPI 3.0** - Swagger automatizado
- **JUnit 5** - Framework de testes
- **Mockito** - Mocking para testes

### Build
- **Maven 3.6+** - Gerenciador de dependências
- **Java 17+** - Linguagem

---

## 🔐 Segurança e Validações

### Validação de Entrada
- ✅ Email único e válido
- ✅ Senhas com mínimo 6 caracteres
- ✅ Campos obrigatórios
- ✅ Preços positivos
- ✅ Quantidade não negativa

### Tratamento de Erros
- ✅ Exceções customizadas
- ✅ Mensagens de erro descritivas
- ✅ Códigos HTTP apropriados (400, 404, 500)

---

## 📊 Banco de Dados

### Tabelas

#### `usuarios`
```sql
CREATE TABLE usuarios (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL
);
```

#### `produtos`
```sql
CREATE TABLE produtos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(200) NOT NULL,
  descricao VARCHAR(1000),
  preco DECIMAL(10, 2) NOT NULL,
  quantidade_estoque INTEGER NOT NULL,
  vendedor_id BIGINT NOT NULL,
  FOREIGN KEY (vendedor_id) REFERENCES usuarios(id)
);
```

---

## 🌐 URLs Principais

| Recurso | URL |
|---------|-----|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| OpenAPI JSON | http://localhost:8080/v3/api-docs |
| Console H2 | http://localhost:8080/h2-console |
| API Base | http://localhost:8080/api |

---

## 🎓 Boas Práticas Implementadas

- ✅ Arquitetura em camadas (Controller → Service → Repository)
- ✅ Uso de DTOs para separar dados da API
- ✅ Transações gerenciadas com @Transactional
- ✅ Validações com annotations (Jakarta Validation)
- ✅ Tratamento centralizado de exceções
- ✅ Documentação automática com Swagger
- ✅ RESTful API design
- ✅ Code organization por funcionalidade

---

## 📈 Evolução Futura

- [ ] Implementar autenticação JWT
- [ ] Adicionar paginação nos GETs
- [ ] Implementar filtros de busca avançada
- [ ] Adicionar rate limiting
- [ ] Testes de integração completos
- [ ] Deploy em nuvem (AWS/Azure)
- [ ] Cache com Redis
- [ ] Logging estruturado (SLF4J + Logback)

---

## 📞 Suporte

Para dúvidas ou problemas:

1. Consulte a [Documentação](docs/)
2. Verifique os [Exemplos de Requisições](docs/EXEMPLOS_REQUISICOES.md)
3. Revise as [Regras e Validações](docs/VALIDACOES_REGRAS.md)
4. Inspecione os logs da aplicação

---

## 📄 Licença

Este projeto está sob a licença Apache 2.0

---

## ✨ Desenvolvido com ❤️ usando Spring Boot

**Última atualização**: Março 2026

**Status**: ✅ Pronto para desenvolvimento e testes
