# Product-Department
API para criação de Product e Department, permitindo criar, atualizar, listar e deletar essas entitades
--- 
## Diagrama de classes
![Image](https://github.com/user-attachments/assets/7dba5bfb-003a-4ad7-9a61-a016e51be0b8)
---
## Tecnologias Utilizadas
- Spring boot
- Spring Data JPA
- Swagger UI
- Postgree
- H2
--- 

## Práticas Adotadas

- Arquitetura em Camadas (Controller,Service,Repository)

- **API RESTful**
- Injeção de Dependência com @Autowired
- DTOs para padronização e seguranã dos dados expostos
- Tramento de erros e exceções
- Documentação com Swagger

--- 

##  Endpoints Disponíveis

| Método | Rota                | Descrição                       |
|--------|---------------------|---------------------------------|
| POST   | `/products`         | Cria um novo produto            |
| GET    | `/products`         | Lista todos os produtos         |
| PUT    | `/products/{id}`    | Atualiza um produto             |
| DELETE | `/products/{id}`    | Deleta um produto existente     |
| POST   | `/departments`      | Cria um novo departamento       |
| GET    | `/departments`      | Lista todos os departamentos    |
| PUT    | `/departments/{id}` | Atualiza um departamento        |
| DELETE | `/departments/{id}` | Deleta um departamento existente|

--- 
## Exemplo de Objeto Json (Product)

```json
{
  "name": "string",
  "price": 0,
  "department": {
    "name": "string"
  }
}
```
## Exemplo de Objeto Json (Department)

```json
{
    "name": "string"
}
```

### Passos para Execução

1. **Clone o repositório:**
   ```bash
   git clone link
   cd pasta
   ```

2. **Configure o perfil do banco de dados:**
   
   Edite o arquivo `application.properties` e escolha o perfil:
   - `test` - Usa H2 Database (em memória)
   - `dev` - Usa PostgreSQL local

3. **Execute o projeto:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a documentação Swagger:**
   
   Abra seu navegador em: http://localhost:8080/swagger-ui.html

##  Estrutura do Projeto

```
com.projeto.todolist/
├── controllers/          # Controladores REST
├── dto/                 # Data Transfer Objects
├── entities/            # Entidades JPA
├── repositories/        # Repositórios de dados
├── services/           # Lógica de negócio
└── ProdutoDepartamentoApplication.java  # Classe principal
```
