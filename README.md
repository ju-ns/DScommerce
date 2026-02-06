# DSCommerce

📦 **DSCommerce** é uma API backend de e-commerce desenvolvida em **Java com Spring Boot** como projeto de estudo, com foco em boas práticas de arquitetura, APIs REST, autenticação e modelagem de domínio.

---

## 🚀 Funcionalidades

- 🔐 Autenticação e autorização com JWT  
- 👤 Cadastro e login de usuários  
- 📦 Listagem de produtos  
- 🛒 Criação e consulta de pedidos  
- 🧪 Banco de dados em memória para desenvolvimento  
- 📊 Persistência temporária durante a execução  
- 🧪 Testes de API via Postman  

---

## 🧱 Tecnologias

- Java 21  
- Spring Boot 3  
- Spring Security  
- Spring Data JPA  
- Hibernate  
- Banco H2 (ambiente de testes)  
- Maven  
- JWT  

---
## 📌 Endpoints da API

Abaixo estão listados os principais endpoints disponíveis na aplicação.  
---

### 🔐 Autenticação

| Método | Endpoint | Descrição |
|-------|---------|----------|
| POST | `/auth/login` | Realiza login e retorna o token JWT |


---

### 📦 Produtos

| Método | Endpoint | Descrição | Acesso |
|-------|---------|----------|--------|
| GET | `/products` | Lista todos os produtos | Público |
| GET | `/products/{id}` | Busca produto por ID | Público |
| PUT | `/products/{id}` | Atualiza um produto existente | ADMIN |
| DELETE | `/products/{id}` | Remove um produto | ADMIN |

---

### 🛒 Pedidos

| Método | Endpoint | Descrição | Acesso |
|-------|---------|----------|--------|
| POST | `/orders` | Cria um novo pedido | Autenticado |
| GET | `/orders/{id}` | Busca pedido por ID | Autenticado |

---

### 👤 Usuários

| Método | Endpoint | Descrição | Acesso |
|-------|---------|----------|--------|
| GET | `/users/me` | Retorna dados do usuário logado | Autenticado |

### 🗂️ Categorias

| Método | Endpoint | Descrição | Acesso |
|-------|---------|----------|--------|
| GET | `/categories` | Lista todas as categorias | Público |


---

> 📌 **Observação:**  
> Alguns endpoints exigem autenticação via **Bearer Token JWT** no header:
>
> ```
> Authorization: Bearer <token>
> ```

## 📄 Exemplos de JSON

A seguir estão alguns exemplos de requisições e respostas da API.

---

### 🔐 Login

**POST** `/oauth2/token`

#### 📤 Request

```json
{
  "username": "alex@email.com",
  "password": "123456"
}

````

📥 Response — 200 OK

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "expires_in": 3600
}

````

### 📦 Listar Produtos

**GET** `/products`

📥 Response — 200 OK

```json

{
    "content": [
        {
            "id": 1,
            "name": "Meu novo produto",
            "price": 200.0,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg"
        }
 ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": false,
    "size": 20,

````

### 📦 Buscar Produto por ID

**GET** ` /products/{id}`

📥 Response — 200 OK

```json
{
    "id": 1,
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "price": 200.0,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "categories": [
        {
            "id": 2,
            "name": "Eletrônicos"
        },
        {
            "id": 3,
            "name": "Computadores"
        }
    ]
}
````

---

### ➕ Cadastrar Produto

**POST** `/products`


#### 📤 Request

```json
{
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "price": 200.0,
    "categories": [
        {
            "id":2
        },
        {
            "id": 3
        }
    ]
}
````

📥 Response — 201 Created

```json
{
    "id": 26,
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "price": 200.0,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "categories": [
        {
            "id": 2,
            "name": null
        },
        {
            "id": 3,
            "name": null
        }
    ]
}

````

> 📌 **Observação:**  
> Esse endpoint é restrito a usuários com perfil administrador.

---

### ✏️ Atualizar Produto

**PUT** `/products/{id}`

> Header:
>
> ```
> Authorization: Bearer <token>
> ```

#### 📤 Request

```json
{
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "price": 200.0,
     "categories": [
        {
            "id": 2
        },
        {
            "id": 3
        }
    ]
}

````
📥 Response — 200 OK

```json
{
    "id": 1,
    "name": "Meu novo produto",
    "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Qui ad, adipisci illum ipsam velit et odit eaque reprehenderit ex maxime delectus dolore labore, quisquam quae tempora natus esse aliquam veniam doloremque quam minima culpa alias maiores commodi. Perferendis enim",
    "price": 200.0,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "categories": [
        {
            "id": 2,
            "name": "Eletrônicos"
        },
        {
            "id": 3,
            "name": "Computadores"
        }
    ]
}

````

---

### 🗑️ Remover Produto

**DELETE** `/products/{id}`

> Header:
>
> ```
> Authorization: Bearer <token>
> ```

#### 📥 Response — 204 No Content

*(Sem corpo de resposta)*

---

---

### 👤 Buscar Usuário Logado

**GET** `/users/me`

> Header:
>
> ```
> Authorization: Bearer <token>
> ```

#### 📥 Response — 200 OK

```json
{
    "id": 2,
    "name": "Alex Green",
    "email": "alex@gmail.com",
    "phone": "977777777",
    "birthDate": "1987-12-13",
    "roles": [
        "ROLE_CLIENT",
        "ROLE_ADMIN"
    ]
}
```
---

### 🛒 Buscar Pedido por ID

**GET** `/orders/{id}`

> Header:
>
> ```
> Authorization: Bearer <token>
> ```

#### 📥 Response — 200 OK

```json
{
  "id": 12,
  "moment": "2026-02-05T18:30:00Z",
  "status": "WAITING_PAYMENT",
  "total": 11999.80,
  "items": [
    {
      "productId": 1,
      "name": "Notebook Gamer",
      "quantity": 2,
      "price": 5999.90,
      "subTotal": 11999.80
    }
  ]
}
```
---

### ➕ Criar Novo Pedido

**POST** `/orders`

> Header:
>
> ```
> Authorization: Bearer <token>
> ```

#### 📤 Request

```json
{
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 5,
      "quantity": 1
    }
  ]
}

```

📥 Response — 201 Created

```json
{
    "id": 4,
    "momment": "2026-02-05T15:20:23.928324800Z",
    "status": "WAITING_PAYMENT",
    "client": {
        "id": 2,
        "name": "Alex Green"
    },
    "payment": null,
    "items": [
        {
            "productId": 1,
            "name": "The Lord of the Rings",
            "price": 90.5,
            "quantity": 2,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
            "subTotal": 181.0
        },
        {
            "productId": 5,
            "name": "Rails for Dummies",
            "price": 100.99,
            "quantity": 1,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg",
            "subTotal": 100.99
        }
    ],
    "total": 281.99
}

```

---

### 🗂️ Listar Categorias

**GET** `/categories`

#### 📥 Response — 200 OK

```json
[
  {
    "id": 1,
    "name": "Eletrônicos"
  },
  {
    "id": 2,
    "name": "Livros"
  },
  {
    "id": 3,
    "name": "Acessórios"
  }
]
```












