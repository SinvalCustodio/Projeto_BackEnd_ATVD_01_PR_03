# 🧪 EXEMPLOS DE REQUISIÇÕES

## 📌 Usando cURL (Linha de Comando)

### Usuários

#### 1. Listar todos os usuários
```bash
curl -X GET "http://localhost:8080/api/usuarios" \
  -H "accept: application/json"
```

#### 2. Buscar usuário por ID
```bash
curl -X GET "http://localhost:8080/api/usuarios/1" \
  -H "accept: application/json"
```

#### 3. Criar novo usuário
```bash
curl -X POST "http://localhost:8080/api/usuarios" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "email": "joao@example.com",
    "senha": "123456"
  }'
```

#### 4. Atualizar usuário
```bash
curl -X PUT "http://localhost:8080/api/usuarios/1" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "senha": "654321"
  }'
```

#### 5. Deletar usuário
```bash
curl -X DELETE "http://localhost:8080/api/usuarios/1" \
  -H "accept: */*"
```

---

### Produtos

#### 1. Listar todos os produtos
```bash
curl -X GET "http://localhost:8080/api/produtos" \
  -H "accept: application/json"
```

#### 2. Buscar produto por ID
```bash
curl -X GET "http://localhost:8080/api/produtos/1" \
  -H "accept: application/json"
```

#### 3. Criar novo produto
```bash
curl -X POST "http://localhost:8080/api/produtos" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell XPS",
    "descricao": "Notebook de alta performance com 16GB de RAM",
    "preco": 3500.50,
    "quantidadeEstoque": 10,
    "vendedorId": 1
  }'
```

#### 4. Atualizar produto
```bash
curl -X PUT "http://localhost:8080/api/produtos/1" \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell XPS 15",
    "descricao": "Notebook de ultra performance com 32GB de RAM",
    "preco": 4500.00,
    "quantidadeEstoque": 8,
    "vendedorId": 1
  }'
```

#### 5. Deletar produto
```bash
curl -X DELETE "http://localhost:8080/api/produtos/1" \
  -H "accept: */*"
```

#### 6. Listar produtos por vendedor
```bash
curl -X GET "http://localhost:8080/api/produtos/vendedor/1" \
  -H "accept: application/json"
```

---

## 📮 Importar no Postman/Insomnia

### JSON Collection para Postman

Salve este arquivo como `marketplace-postman-collection.json`:

```json
{
  "info": {
    "_postman_id": "marketplace-api",
    "name": "Marketplace API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Usuários",
      "item": [
        {
          "name": "Listar Usuários",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/usuarios",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "usuarios"]
            }
          }
        },
        {
          "name": "Buscar Usuário por ID",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/usuarios/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "usuarios", "1"]
            }
          }
        },
        {
          "name": "Criar Usuário",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"João Silva\",\n  \"email\": \"joao@example.com\",\n  \"senha\": \"123456\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/usuarios",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "usuarios"]
            }
          }
        },
        {
          "name": "Atualizar Usuário",
          "request": {
            "method": "PUT",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"João da Silva\",\n  \"email\": \"joao.silva@example.com\",\n  \"senha\": \"654321\"\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/usuarios/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "usuarios", "1"]
            }
          }
        },
        {
          "name": "Deletar Usuário",
          "request": {
            "method": "DELETE",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/usuarios/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "usuarios", "1"]
            }
          }
        }
      ]
    },
    {
      "name": "Produtos",
      "item": [
        {
          "name": "Listar Produtos",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos"]
            }
          }
        },
        {
          "name": "Buscar Produto por ID",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/produtos/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos", "1"]
            }
          }
        },
        {
          "name": "Criar Produto",
          "request": {
            "method": "POST",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"Notebook Dell\",\n  \"descricao\": \"Notebook de alta performance\",\n  \"preco\": 3500.00,\n  \"quantidadeEstoque\": 10,\n  \"vendedorId\": 1\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos"]
            }
          }
        },
        {
          "name": "Atualizar Produto",
          "request": {
            "method": "PUT",
            "header": [
              {
                "key": "Content-Type",
                "value": "application/json"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"Notebook Dell XPS\",\n  \"descricao\": \"Notebook de ultra performance com 32GB RAM\",\n  \"preco\": 4500.00,\n  \"quantidadeEstoque\": 8,\n  \"vendedorId\": 1\n}"
            },
            "url": {
              "raw": "http://localhost:8080/api/produtos/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos", "1"]
            }
          }
        },
        {
          "name": "Deletar Produto",
          "request": {
            "method": "DELETE",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/produtos/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos", "1"]
            }
          }
        },
        {
          "name": "Listar Produtos por Vendedor",
          "request": {
            "method": "GET",
            "header": [],
            "url": {
              "raw": "http://localhost:8080/api/produtos/vendedor/1",
              "protocol": "http",
              "host": ["localhost"],
              "port": "8080",
              "path": ["api", "produtos", "vendedor", "1"]
            }
          }
        }
      ]
    }
  ]
}
```

### Como Importar no Postman
1. Abra o Postman
2. Clique em **File** → **Import**
3. Selecione o arquivo `marketplace-postman-collection.json`
4. Clique em **Import**
5. Pronto! Todos os endpoints estarão disponíveis

---

## 🔍 JavaScript Fetch (Frontend)

### Criar Usuário
```javascript
fetch('http://localhost:8080/api/usuarios', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    nome: 'João Silva',
    email: 'joao@example.com',
    senha: '123456'
  })
})
.then(response => response.json())
.then(data => console.log('Usuário criado:', data))
.catch(error => console.error('Erro:', error));
```

### Listar Usuários
```javascript
fetch('http://localhost:8080/api/usuarios')
  .then(response => response.json())
  .then(data => console.log('Usuários:', data))
  .catch(error => console.error('Erro:', error));
```

### Criar Produto
```javascript
fetch('http://localhost:8080/api/produtos', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    nome: 'Notebook',
    descricao: 'Notebook de alto desempenho',
    preco: 3500.00,
    quantidadeEstoque: 10,
    vendedorId: 1
  })
})
.then(response => response.json())
.then(data => console.log('Produto criado:', data))
.catch(error => console.error('Erro:', error));
```

---

## 🐍 Python Requests

```python
import requests
import json

BASE_URL = 'http://localhost:8080/api'

# Criar usuário
usuario = {
    'nome': 'João Silva',
    'email': 'joao@example.com',
    'senha': '123456'
}
response = requests.post(f'{BASE_URL}/usuarios', json=usuario)
print(response.json())

# Listar usuários
response = requests.get(f'{BASE_URL}/usuarios')
print(response.json())

# Criar produto
produto = {
    'nome': 'Notebook',
    'descricao': 'Notebook de alto desempenho',
    'preco': 3500.00,
    'quantidadeEstoque': 10,
    'vendedorId': 1
}
response = requests.post(f'{BASE_URL}/produtos', json=produto)
print(response.json())

# Listar produtos
response = requests.get(f'{BASE_URL}/produtos')
print(response.json())
```

---

## ✨ Notas Importantes

- ✅ Todos os exemplos assumem que a aplicação está rodando em `localhost:8080`
- ✅ Respeite as validações (email único, campos obrigatórios, etc)
- ✅ O `vendedorId` em produtos deve referir a um usuário existente
- ✅ Datas são retornadas em formato ISO 8601
- ✅ Preços usam BigDecimal (até 2 casas decimais)

