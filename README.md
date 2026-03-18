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

## 🧪 Testes Unitários — Camada de Service

![Coverage](https://img.shields.io/badge/coverage-100%25-brightgreen)

A aplicação conta com cobertura de testes unitários na camada de serviço utilizando **JUnit 5** e **Mockito**, sem subir contexto Spring (via `@ExtendWith(SpringExtension.class)`).

A cobertura é verificada com **JaCoCo** e atinge **100% na camada de service**, validando métodos, branches e linhas de todos os serviços da aplicação.

> ▶️ Para gerar o relatório de cobertura localmente:
> ```bash
> ./mvnw test jacoco:report
> ```
> O relatório HTML será gerado em `target/site/jacoco/index.html`.

---

### ✅ CategoryService

| Teste | Cenário |
|-------|---------|
| `findAllShouldReturnListCategoryDTO` | Deve retornar uma lista de `CategoryDTO` com os dados corretos |

---

### ✅ AuthService

| Teste | Cenário |
|-------|---------|
| `validateSelfOrAdminShouldDoNothingWhenAdminLogged` | Não deve lançar exceção quando o usuário logado é ADMIN |
| `validateSelfOrAdminShouldDoNothingWhenSelfLogged` | Não deve lançar exceção quando o próprio usuário acessa o recurso |
| `validateSelfOrAdminThrowsForbiddenExceptionWhenOtherClientLogged` | Deve lançar `ForbiddenException` quando outro cliente tenta acessar |

---

### ✅ UserService

| Teste | Cenário |
|-------|---------|
| `loadUserByUsernameShouldReturnUserDetailsWhenUserExists` | Deve retornar `UserDetails` quando o usuário existir |
| `loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists` | Deve lançar `UsernameNotFoundException` quando o usuário não existir |
| `authenticatedReturnUserWhenUserExists` | Deve retornar o `User` autenticado quando o usuário existir |
| `authenticatedShouldThrowUserNotFoundExceptionWhenUserDoesNotExists` | Deve lançar `UsernameNotFoundException` quando o usuário não estiver autenticado |
| `getMeShouldReturnUserDTOWhenUserAunthenticated` | Deve retornar `UserDTO` com os dados corretos quando autenticado |
| `getMeShouldThrowUserNotFoundExceptionWhenUserNotAuthenticated` | Deve lançar `UsernameNotFoundException` quando não autenticado |

---

### ✅ ProductService

| Teste | Cenário |
|-------|---------|
| `findByIdShouldReturnProductDTOWhenIdExists` | Deve retornar `ProductDTO` quando o ID existir |
| `findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists` | Deve lançar `ResourceNotFoundException` quando o ID não existir |
| `findAllShouldReturnPagedProductMinDTO` | Deve retornar página de `ProductMinDTO` |
| `insertShouldReturnProductDTO` | Deve retornar `ProductDTO` ao inserir produto |
| `updateShouldReturnProductDTOWhenIdExists` | Deve retornar `ProductDTO` ao atualizar produto existente |
| `updateShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists` | Deve lançar `ResourceNotFoundException` ao atualizar ID inexistente |
| `deleteShouldDoNothingWhenIdExists` | Não deve lançar exceção ao deletar produto existente |
| `deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists` | Deve lançar `ResourceNotFoundException` ao deletar ID inexistente |
| `deleteShouldThrowDatabaseExceptionWhenDependentId` | Deve lançar `DatabaseException` ao deletar produto com dependência |

---

### ✅ OrderService

| Teste | Cenário |
|-------|---------|
| `findByIdShouldReturnOrderDTOWhenIdExistsAndAdminLogged` | Deve retornar `OrderDTO` quando o ID existir e o ADMIN estiver logado |
| `findByIdShouldReturnOrderDTOWhenIdExistsAndSelfClientLogged` | Deve retornar `OrderDTO` quando o ID existir e o próprio cliente estiver logado |
| `findByIdShouldThrowForbiddenExceptionWhenIdExistsAndOtherClientLogged` | Deve lançar `ForbiddenException` quando outro cliente tentar acessar o pedido |
| `findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists` | Deve lançar `ResourceNotFoundException` quando o ID não existir |
| `insertShouldReturnOrderDTOWhenAdminLogged` | Deve retornar `OrderDTO` ao inserir pedido com ADMIN logado |
| `insertShouldThrowsUsernameNotFoundExceptionWhenUserNotLogged` | Deve lançar `UsernameNotFoundException` quando nenhum usuário estiver logado |
| `insertShouldThrowsEntityNotFoundExceptionWhenOrderProductIdDoesNotExists` | Deve lançar `EntityNotFoundException` quando o produto do pedido não existir |

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
```

📥 Response — 200 OK

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "expires_in": 3600
}
```

---

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
  "size": 20
}
```

---

### 📦 Buscar Produto por ID

**GET** `/products/{id}`

📥 Response — 200 OK

```json
{
  "id": 1,
  "name": "Meu novo produto",
  "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit...",
  "price": 200.0,
  "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
  "categories": [
    { "id": 2, "name": "Eletrônicos" },
    { "id": 3, "name": "Computadores" }
  ]
}
```

---

### ➕ Cadastrar Produto

**POST** `/products`

#### 📤 Request

```json
{
  "name": "Meu novo produto",
  "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit...",
  "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
  "price": 200.0,
  "categories": [
    { "id": 2 },
    { "id": 3 }
  ]
}
```

📥 Response — 201 Created

```json
{
  "id": 26,
  "name": "Meu novo produto",
  "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit...",
  "price": 200.0,
  "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
  "categories": [
    { "id": 2, "name": null },
    { "id": 3, "name": null }
  ]
}
```

> 📌 **Observação:**  
> Esse endpoint é restrito a usuários com perfil administrador.

---

### ✏️ Atualizar Produto

**PUT** `/products/{id}`

> Header:
> ```
> Authorization: Bearer <token>
> ```

#### 📤 Request

```json
{
  "name": "Meu novo produto",
  "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit...",
  "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
  "price": 200.0,
  "categories": [
    { "id": 2 },
    { "id": 3 }
  ]
}
```

📥 Response — 200 OK

```json
{
  "id": 1,
  "name": "Meu novo produto",
  "description": "Lorem ipsum, dolor sit amet consectetur adipisicing elit...",
  "price": 200.0,
  "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
  "categories": [
    { "id": 2, "name": "Eletrônicos" },
    { "id": 3, "name": "Computadores" }
  ]
}
```

---

### 🗑️ Remover Produto

**DELETE** `/products/{id}`

> Header:
> ```
> Authorization: Bearer <token>
> ```

#### 📥 Response — 204 No Content

*(Sem corpo de resposta)*

---

### 👤 Buscar Usuário Logado

**GET** `/users/me`

> Header:
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
> ```
> Authorization: Bearer <token>
> ```

#### 📤 Request

```json
{
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 5, "quantity": 1 }
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
  { "id": 1, "name": "Eletrônicos" },
  { "id": 2, "name": "Livros" },
  { "id": 3, "name": "Acessórios" }
]
```
