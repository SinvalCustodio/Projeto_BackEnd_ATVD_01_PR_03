# 🚀 GUIA DE INICIAÇÃO RÁPIDA

## ✅ Pré-requisitos

- ✔️ Java 17+ instalado
- ✔️ Maven 3.6+ instalado
- ✔️ IDE (IntelliJ IDEA, Eclipse ou VS Code)
- ✔️ Git (opcional)

---

## 📋 Passo 1: Preparar o Projeto

### 1.1 Verificar a estrutura de pastas
Certifique-se que seu projeto tem esta estrutura:

```
CRUD/
├── src/main/java/com/example/marketplace/
│   ├── config/
│   │   ├── application.properties
│   │   └── SwaggerConfig.java
│   ├── controller/
│   │   ├── UsuarioController.java
│   │   └── ProdutoController.java
│   ├── service/
│   │   ├── UsuarioService.java
│   │   └── ProdutoService.java
│   ├── dto/
│   │   ├── UsuarioRequestDTO.java
│   │   ├── UsuarioResponseDTO.java
│   │   ├── ProdutoRequestDTO.java
│   │   └── ProdutoResponseDTO.java
│   ├── model/
│   │   ├── Usuario.java
│   │   ├── Produto.java
│   │   └── MarketplaceApplication.java
│   ├── repository/
│   │   ├── UsuarioRepository.java
│   │   └── ProdutoRepository.java
│   └── exception/
│       ├── GlobalExceptionHandler.java
│       └── ResourceNotFoundException.java
├── pom.xml
└── docs/
    ├── API_ENDPOINTS.md
    ├── DEPENDENCIAS_MAVEN.md
    ├── VALIDACOES_REGRAS.md
    ├── exemplos_requisicoes/
    └── testes/
```

### 1.2 Atualizar pom.xml
Se você ainda não tem o arquivo `pom.xml`, copie o arquivo fornecido para a raiz do projeto.

---

## 🔧 Passo 2: Instalar Dependências

### Usando Maven (recomendado)

```bash
# Navegar até a pasta do projeto
cd "C:\Users\pctat\OneDrive\Área de Trabalho\ADS 2024.2\3° - PERIODO\BECKEND\CRUD"

# Instalar dependências
mvn clean install

# Ou apenas fazer download das dependências
mvn dependency:resolve
```

### Usando IDE
- **IntelliJ IDEA**: File → Project Structure → Maven → Reimport
- **Eclipse**: Right-click no projeto → Maven → Update Project
- **VS Code**: Extensão Maven for Java → Instalar dependências

---

## 🎯 Passo 3: Executar a Aplicação

### Opção 1: Linha de Comando (Maven)
```bash
cd "C:\Users\pctat\OneDrive\Área de Trabalho\ADS 2024.2\3° - PERIODO\BECKEND\CRUD"
mvn spring-boot:run
```

### Opção 2: Usando IDE
1. Localize a classe `MarketplaceApplication.java` em `model/`
2. Clique com botão direito → **Run as Java Application**
3. Ou use o atalho: `Shift + Alt + X, J` (Eclipse) ou `Run` (IntelliJ)

### Opção 3: Build JAR e Executar
```bash
# Build
mvn clean package

# Executar JAR
java -jar target/marketplace-1.0.0.jar
```

---

## ✨ Passo 4: Acessar o Swagger

Depois que a aplicação estiver rodando, abra seu navegador e acesse:

### 🌐 URLs Principais

| Recurso | URL |
|---------|-----|
| **Swagger UI** | http://localhost:8080/swagger-ui.html |
| **OpenAPI JSON** | http://localhost:8080/v3/api-docs |
| **Console H2** | http://localhost:8080/h2-console |

### Credenciais do Banco H2
- **Driver**: `org.h2.Driver`
- **URL JDBC**: `jdbc:h2:mem:marketplacedb`
- **Usuário**: `sa`
- **Senha**: (deixar em branco)

---

## 🧪 Passo 5: Testar os Endpoints

### No Swagger UI
1. Acesse http://localhost:8080/swagger-ui.html
2. Você verá dois grupos de endpoints:
   - 🔵 **Usuários** (`/api/usuarios`)
   - 🟢 **Produtos** (`/api/produtos`)

### Exemplo de Teste:

#### 1️⃣ Criar um Usuário
```bash
POST /api/usuarios
Content-Type: application/json

{
  "nome": "João Silva",
  "email": "joao@example.com",
  "senha": "123456"
}
```

#### 2️⃣ Listar Usuários
```bash
GET /api/usuarios
```

#### 3️⃣ Criar um Produto
```bash
POST /api/produtos
Content-Type: application/json

{
  "nome": "Notebook",
  "descricao": "Notebook de alta performance",
  "preco": 3500.00,
  "quantidadeEstoque": 5,
  "vendedorId": 1
}
```

#### 4️⃣ Listar Produtos
```bash
GET /api/produtos
```

---

## 🐛 Troubleshooting

### Erro: "Maven not found"
```bash
# Adicione Maven ao PATH ou use:
"C:\Program Files\Apache Maven\apache-maven-x.x.x\bin\mvn" clean install
```

### Erro: "Port 8080 already in use"
```bash
# Mude a porta no application.properties:
server.port=8081

# Ou libere a porta:
netstat -ano | findstr :8080  # Achar PID
taskkill /PID <PID> /F         # Matar processo
```

### Erro: "Java version not compatible"
```bash
# Verifique sua versão de Java:
java -version

# Se necessário, configure em pom.xml:
<java.version>17</java.version>
```

### Swagger não aparece
1. Verifique se as dependências foram instaladas: `mvn dependency:tree`
2. Confirme que `application.properties` está configurado corretamente
3. Reinicie a aplicação
4. Verifique os logs: procure por "springdoc"

---

## 📊 Estrutura de Resposta

Todas as respostas seguem um padrão REST:

### ✅ Sucesso (200/201)
```json
{
  "id": 1,
  "nome": "Produto",
  "descricao": "Descrição"
}
```

### ❌ Erro (400/404/500)
```json
{
  "timestamp": "2024-03-11T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Usuário não encontrado com ID: 999"
}
```

---

## 📝 Dicas de Desenvolvimento

1. **Use Postman ou Insomnia** para testar APIs de forma mais avançada
2. **Consulte os logs** para debug: procure por `WARN` ou `ERROR`
3. **Valide os dados** antes de enviar: respeite as regras de validação
4. **Use o H2 Console** para inspecionar o banco de dados em tempo real
5. **Ative debug mode** em `application.properties`:
   ```properties
   logging.level.root=INFO
   logging.level.com.example.marketplace=DEBUG
   ```

---

## 🎓 Próximos Passos

1. ✅ Implementar autenticação JWT
2. ✅ Adicionar testes unitários (JUnit 5 + Mockito)
3. ✅ Implementar paginação nos endpoints GET
4. ✅ Adicionar filtros de busca
5. ✅ Implementar rate limiting
6. ✅ Documentar regras de negócio adicionais
7. ✅ Deploy em produção (AWS, Azure, Heroku)

---

## 📞 Suporte

Se encontrar problemas:
1. Verifique o arquivo `API_ENDPOINTS.md`
2. Consulte `VALIDACOES_REGRAS.md`
3. Revise os logs da aplicação
4. Procure erros específicos no Google

---

**Bom desenvolvimento! 🚀**
