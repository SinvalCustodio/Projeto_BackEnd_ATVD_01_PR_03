# 🔒 VALIDAÇÕES E REGRAS DE NEGÓCIO

## Validações de Entrada

### Usuário

| Campo | Validação | Mensagem de Erro |
|-------|-----------|------------------|
| Nome | Obrigatório, Max 100 chars | "Nome é obrigatório" |
| Email | Obrigatório, Válido, Único | "E-mail é obrigatório", "E-mail inválido", "E-mail já cadastrado" |
| Senha | Obrigatório, Min 6 chars | "Senha é obrigatória", "A senha deve ter no mínimo 6 caracteres" |

### Produto

| Campo | Validação | Mensagem de Erro |
|-------|-----------|------------------|
| Nome | Obrigatório | "Nome do produto é obrigatório" |
| Descrição | Obrigatório | "Descrição do produto é obrigatória" |
| Preço | Obrigatório, > 0 | "Preço é obrigatório", "O preço deve ser maior que zero" |
| Quantidade | Obrigatório, >= 0 | "Quantidade em estoque é obrigatória", "A quantidade não pode ser negativa" |
| VendedorId | Obrigatório, Válido | "ID do vendedor é obrigatório", "Vendedor não encontrado" |

---

## Regras de Negócio

### ✅ Usuários
- Não pode haver dois usuários com o mesmo email
- E-mail é único no sistema
- Senha deve ter no mínimo 6 caracteres (em produção, deve ser criptografada com BCrypt)
- Um usuário pode ter vários produtos como vendedor

### ✅ Produtos
- Cada produto deve ter um vendedor válido (usuário existente)
- O preço é um valor decimal com até 2 casas decimais
- A quantidade em estoque não pode ser negativa
- Quando um usuário é deletado, todos seus produtos também são deletados

---

## Exemplos de Requisições Válidas

### ✅ Usuário Válido
```json
{
  "nome": "João da Silva",
  "email": "joao.silva@email.com",
  "senha": "senhaSegura123"
}
```

### ❌ Usuário Inválido
```json
{
  "nome": "",  // ❌ Vazio
  "email": "email-invalido",  // ❌ Não é um email válido
  "senha": "123"  // ❌ Menos de 6 caracteres
}
```

### ✅ Produto Válido
```json
{
  "nome": "Notebook Dell XPS",
  "descricao": "Notebook de alta performance com 16GB RAM",
  "preco": 3500.50,
  "quantidadeEstoque": 10,
  "vendedorId": 1
}
```

### ❌ Produto Inválido
```json
{
  "nome": "",  // ❌ Vazio
  "descricao": "Produto sem nome",
  "preco": -100,  // ❌ Preço negativo
  "quantidadeEstoque": -5,  // ❌ Quantidade negativa
  "vendedorId": 999  // ❌ Vendedor não existe
}
```

---

## Códigos de Erro

### 400 Bad Request
Aplicável quando:
- Dados de entrada inválidos
- Violação de uma regra de validação
- Email já cadastrado
- Formato incorreto do JSON

### 404 Not Found
Aplicável quando:
- Usuário não encontrado
- Produto não encontrado
- Vendedor não encontrado

### 500 Internal Server Error
Erro imprevisto no servidor

---

## ⚠️ Casos de Uso Importantes

### Caso 1: Tentar criar usuário com email duplicado
**Requisição**:
```
POST /api/usuarios
{
  "nome": "Novo Usuário",
  "email": "joao@example.com",  // Já existe
  "senha": "123456"
}
```
**Resposta**: 400 Bad Request
```json
{
  "message": "E-mail já cadastrado"
}
```

### Caso 2: Tentar criar produto sem vendedor válido
**Requisição**:
```
POST /api/produtos
{
  "nome": "Produto",
  "descricao": "Descrição",
  "preco": 100.00,
  "quantidadeEstoque": 5,
  "vendedorId": 999  // Não existe
}
```
**Resposta**: 404 Not Found
```json
{
  "message": "Vendedor não encontrado com ID: 999"
}
```

### Caso 3: Tentar buscar usuário inexistente
**Requisição**:
```
GET /api/usuarios/999
```
**Resposta**: 404 Not Found
```json
{
  "message": "Usuário não encontrado com ID: 999"
}
```

---

## 🔄 Fluxo de Validação

```
Requisição Recebida
    ↓
Validação de Sintaxe (JSON válido?)
    ↓
Validação de Tipo (tipos de dados corretos?)
    ↓
Validações de Annotations (@NotBlank, @Email, etc)
    ↓
Validações de Negócio (email único, vendedor existe?, etc)
    ↓
Se OK: Processar | Se ERRO: Retornar 400/404
```

---

## 📚 Notas Importantes

1. **Transações**: As operações de escrita usam @Transactional
2. **Read-Only**: As operações de leitura usam @Transactional(readOnly = true) para melhor performance
3. **HTTP Status**: Seguem as práticas RESTful padrão
4. **DTOs**: Separam a camada de apresentação da lógica de negócio
