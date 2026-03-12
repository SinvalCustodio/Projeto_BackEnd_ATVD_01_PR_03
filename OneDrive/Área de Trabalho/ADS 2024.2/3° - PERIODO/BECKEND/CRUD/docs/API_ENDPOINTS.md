# 📚 GUIA DE ENDPOINTS - API Marketplace

## 🚀 Como Acessar o Swagger

Depois de iniciar a aplicação Spring Boot, acesse:

```
http://localhost:8080/swagger-ui.html
```

---

## 👥 ENDPOINTS DE USUÁRIOS

### 1. **Listar todos os usuários**
- **Método**: `GET`
- **Rota**: `/api/usuarios`
- **Descrição**: Retorna lista de todos os usuários cadastrados
- **Resposta**: 200 OK
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@example.com"
  },
  {
    "id": 2,
    "nome": "Maria Santos",
    "email": "maria@example.com"
  }
]
```

### 2. **Buscar usuário por ID**
- **Método**: `GET`
- **Rota**: `/api/usuarios/{id}`
- **Parâmetro**: `id` (Long) - ID do usuário
- **Resposta**: 200 OK ou 404 Not Found
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

### 3. **Criar novo usuário**
- **Método**: `POST`
- **Rota**: `/api/usuarios`
- **Body** (JSON):
```json
{
  "nome": "Paulo Costa",
  "email": "paulo@example.com",
  "senha": "123456"
}
```
- **Resposta**: 201 Created
```json
{
  "id": 3,
  "nome": "Paulo Costa",
  "email": "paulo@example.com"
}
```

### 4. **Atualizar usuário**
- **Método**: `PUT`
- **Rota**: `/api/usuarios/{id}`
- **Body** (JSON):
```json
{
  "nome": "Paulo Costa Silva",
  "email": "paulo.silva@example.com",
  "senha": "654321"
}
```
- **Resposta**: 200 OK

### 5. **Deletar usuário**
- **Método**: `DELETE`
- **Rota**: `/api/usuarios/{id}`
- **Resposta**: 204 No Content

---

## 📦 ENDPOINTS DE PRODUTOS

### 1. **Listar todos os produtos**
- **Método**: `GET`
- **Rota**: `/api/produtos`
- **Resposta**: 200 OK
```json
[
  {
    "id": 1,
    "nome": "Notebook",
    "descricao": "Notebook com 16GB RAM",
    "preco": 3500.00,
    "quantidadeEstoque": 5,
    "vendedorId": 1,
    "vendedorNome": "João Silva"
  }
]
```

### 2. **Buscar produto por ID**
- **Método**: `GET`
- **Rota**: `/api/produtos/{id}`
- **Resposta**: 200 OK ou 404 Not Found

### 3. **Criar novo produto**
- **Método**: `POST`
- **Rota**: `/api/produtos`
- **Body** (JSON):
```json
{
  "nome": "Smartphone",
  "descricao": "Smartphone 5G com câmera 108MP",
  "preco": 1500.00,
  "quantidadeEstoque": 10,
  "vendedorId": 1
}
```
- **Resposta**: 201 Created
```json
{
  "id": 2,
  "nome": "Smartphone",
  "descricao": "Smartphone 5G com câmera 108MP",
  "preco": 1500.00,
  "quantidadeEstoque": 10,
  "vendedorId": 1,
  "vendedorNome": "João Silva"
}
```

### 4. **Atualizar produto**
- **Método**: `PUT`
- **Rota**: `/api/produtos/{id}`
- **Body** (JSON):
```json
{
  "nome": "Smartphone 5G",
  "descricao": "Smartphone 5G com câmera 108MP melhorada",
  "preco": 1600.00,
  "quantidadeEstoque": 8,
  "vendedorId": 1
}
```
- **Resposta**: 200 OK

### 5. **Deletar produto**
- **Método**: `DELETE`
- **Rota**: `/api/produtos/{id}`
- **Resposta**: 204 No Content

### 6. **Listar produtos por vendedor**
- **Método**: `GET`
- **Rota**: `/api/produtos/vendedor/{vendedorId}`
- **Parâmetro**: `vendedorId` (Long) - ID do vendedor
- **Resposta**: 200 OK
```json
[
  {
    "id": 1,
    "nome": "Notebook",
    "descricao": "Notebook com 16GB RAM",
    "preco": 3500.00,
    "quantidadeEstoque": 5,
    "vendedorId": 1,
    "vendedorNome": "João Silva"
  },
  {
    "id": 2,
    "nome": "Smartphone",
    "descricao": "Smartphone 5G",
    "preco": 1500.00,
    "quantidadeEstoque": 10,
    "vendedorId": 1,
    "vendedorNome": "João Silva"
  }
]
```

---

## ⚙️ CÓDIGOS DE RESPOSTA HTTP

| Código | Significado |
|--------|-------------|
| 200 | OK - Requisição bem-sucedida |
| 201 | Created - Recurso criado com sucesso |
| 204 | No Content - Operação bem-sucedida sem conteúdo |
| 400 | Bad Request - Dados inválidos |
| 404 | Not Found - Recurso não encontrado |
| 500 | Internal Server Error - Erro no servidor |

---

## 🧪 Testando no Swagger UI

1. Acesse http://localhost:8080/swagger-ui.html
2. Clique em um endpoint para expandir
3. Clique no botão **"Try it out"**
4. Preencha os parâmetros necessários
5. Clique em **"Execute"**
6. Veja a resposta em **"Response"**

---

## 💡 Exemplo de Fluxo Completo

1. **Criar um usuário (vendedor)**:
   - `POST /api/usuarios` com nome, email e senha
   
2. **Criar um produto**:
   - `POST /api/produtos` informando o `vendedorId` do usuário criado
   
3. **Listar produtos do vendedor**:
   - `GET /api/produtos/vendedor/{vendedorId}`
   
4. **Atualizar produto**:
   - `PUT /api/produtos/{id}` com dados atualizados
   
5. **Deletar produto**:
   - `DELETE /api/produtos/{id}`

---

## 📝 Validações Importantes

### Usuário
- **Nome**: Obrigatório, máximo 100 caracteres
- **Email**: Obrigatório, deve ser válido e único
- **Senha**: Obrigatório, mínimo 6 caracteres

### Produto
- **Nome**: Obrigatório
- **Descrição**: Obrigatório
- **Preço**: Obrigatório, deve ser maior que 0
- **Quantidade**: Obrigatório, não pode ser negativo
- **VendedorId**: Obrigatório, vendedor deve existir

---

**Desenvolvido com ❤️ usando Spring Boot 3.0+**
