# Editora Abril Teste
## _Spring Boot API_

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)

## Requirements

Para construir e executar o aplicativo, você precisa:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Spring Boot](http://projects.spring.io/spring-boot/)
- [Maven 3](https://maven.apache.org)

## Ferramentas

*   [SPRING INITIALIZR](https://start.spring.io)
    ### _Frameworks_
*   [Spring Boot](http://projects.spring.io/spring-boot)
*   [Spring Data REST](http://projects.spring.io/spring-data-rest)
*   [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
*   [Apache Maven](https://spring.io/projects/spring-data-jpa)
    ### _Documentação_
*   [Swagger](https://swagger.io/)
    ### _Banco de Dados_
*   [H2 Database Engine](https://www.h2database.com/html/main.html)
    ### _Tecnologia_
*   [Java 8](https://www.java.com/pt-BR/download/help/java8_pt-br.html)

## Executando o aplicativo localmente

Existem várias maneiras de executar esta API Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe `com.abril.editora.TestApplication` de seu IDE.

Alternativamente, você pode usar o [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) igual a:


# Sobre o projeto
## Acessando a Documentação
```
http://localhost:8080/swagger-ui.html
```

![Swagger Image](https://github.com/jellitBarack/Editora-Abril/blob/main/swagger_doc.png?raw=true)


### Exercicio 01
#  `User Controller`
### `[ POST ]` - /user/save
_Salva uma lista de usuários com nome e senha criptografando a senha do usuário_
```json
[
  {
    "nome": "Ana",
    "pass": "112233"
  }
]
```
_Response body_
```json
[
  {
    "id": 1,
    "nome": "João",
    "pass": "E0BC60C82713F64EF8A57C0C40D02CE24FD0141D5CC3086259C19B1E62A62BEA"
  }
]
```
### `[ GET ]` - /user
_Retorna uma lista de usuários pré inserido na base de dados_
```json
[
    { "id": 1, "nome": "Ana" },
    { "id": 2, "nome": "Bruno" },
    { "id": 3, "nome": "Leo" },
    { "id": 4, "nome": "Juca" },
    { "id": 5, "nome": "Carlos" },
    { "id": 6, "nome": "Mara" }
]
```
### `[ GET ]` - /user/{nome}/{pass}
_Encontra um usuário pelo nome e senha_
![Test Image 1](https://github.com/jellitBarack/Editora-Abril/blob/main/image.png?raw=true)

_Response body_
```json
{
  "id": 1,
  "nome": "Ana",
  "pass": "E0BC60C82713F64EF8A57C0C40D02CE24FD0141D5CC3086259C19B1E62A62BEA"
}
```

### Exercicio 02
- `Resposta 01` - Função foi criada na _Assinatura Endereco Controller_ descrita logo abaixo

- `Resposta 02` - Criação de Indice para CEP, TIPO ENDEREÇO e ID PRODUTO

- `Resposta 03` - Imagem da HQL criada no projeto:

![HQL Image](https://github.com/jellitBarack/Editora-Abril/blob/main/Ex2_hql.png?raw=true)

```java
@Query("select ae from AssinaturaEndereco ae " +
            "inner join Assinatura a on ae.assinaturaId = a.id " +
            "where ae.cep = :cep " +
            "and a.produtoId = :productId " +
            "and ae.tipoEndereco = :tipoEndereco ")
```

#  `Pessoa Controller`
### `[ POST ]` - /person/save
_Salva uma pessoa_
```json
{
  "nome": "Julius"
}
```
_Response body_
```json
{ "id": 7, "nome": "Julius" }
```
### `[ GET ]` - /person
_Retorna uma lista de pessoas_

_Response body_
```json
[
  { "id": 1, "nome": "Ana" },
  { "id": 2, "nome": "Bruno" },
  { "id": 3, "nome": "Leo" },
  { "id": 4, "nome": "Juca" },
  { "id": 5, "nome": "Carlos" },
  { "id": 6, "nome": "Mara" },
  { "id": 7, "nome": "Julius" }
]
```

### `[ GET ]` - /person/{id}
_Encontra assinatura pelo Id_

_Response body_
```json
{ "id": 7, "nome": "Julius" }
```

### `[ DELETE ]` - /person/{id}
_Deleta uma pessoa pelo Id_

_Response body_
```
"FORBIDDEN"
```

# `Assinatura Controller`
### `[ POST ]` - /signature/save
_Salva uma assinatura_
```json
{
  "nome": "Julius"
}
```
_Response body_
```json
{ "id": 7, "nome": "Julius" }
```
### `[ GET ]` - /signature
_Retorna uma lista de assinaturas_

_Response body_
```json
[
  {
    "id": 1,
    "pessoaId": 1,
    "produtoId": 55
  },
  {
    "id": 2,
    "pessoaId": 2,
    "produtoId": 49
  },
  {
    "id": 3,
    "pessoaId": 3,
    "produtoId": 55
  },
  {
    "id": 4,
    "pessoaId": 4,
    "produtoId": 38
  },
  {
    "id": 5,
    "pessoaId": 5,
    "produtoId": 55
  },
  {
    "id": 6,
    "pessoaId": 6,
    "produtoId": 22
  }
]
```

### `[ GET ]` - /signature/{id}
_Encontra assinatura pelo Id_

_Response body_
```json
{
  "id": 5,
  "pessoaId": 5,
  "produtoId": 55
}
```

### `[ DELETE ]` - /signature/{id}
_Deleta uma assinatura pelo Id_

_Response body_
```
"FORBIDDEN"
```

# `Assinatura Endereco Controller`
### `[ POST ]` - /signature/address/save
_Salva um Endereco de Assinatura_
```json
{
  "assinaturaId": 1,
  "cep": "81920010",
  "tipoEndereco": "COBRANCA"
}
```
_Response body_
```json
{
  "id": 7,
  "assinaturaId": 1,
  "tipoEndereco": "COBRANCA",
  "cep": "81920010"
}
```
### `[ GET ]` - /signature/address
_Retorna uma lista de assinaturas previamente inseridos no projeto_

_Response body_
```json
[
  {
    "id": 1,
    "assinaturaId": 1,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 2,
    "assinaturaId": 2,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 3,
    "assinaturaId": 3,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 4,
    "assinaturaId": 4,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 5,
    "assinaturaId": 5,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 6,
    "assinaturaId": 6,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  }
]
```

### `[ GET ]` - /signature/address/{id}
_Encontra Endereco de Assinatura pelo Id_

_Response body_
```json
{
  "id": 1,
  "assinaturaId": 1,
  "tipoEndereco": "ENTREGA",
  "cep": "6190001"
}
```

### `[ GET ]` - /signature/address/{cep}/{productId}
_Encontra todas as pessoas com assinatura com endereço do tipo ENTREGA pelo cep e produto informado_
![Resposta 2 Image](https://github.com/jellitBarack/Editora-Abril/blob/main/Ex2.png?raw=true)


_Response body_
```json
[
  {
    "id": 1,
    "assinaturaId": 1,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 3,
    "assinaturaId": 3,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  },
  {
    "id": 5,
    "assinaturaId": 5,
    "tipoEndereco": "ENTREGA",
    "cep": "6190001"
  }
]
```

### `[ DELETE ]` - /signature/address/{id}
_Deleta um Endereco de Assinatura pelo Id_

_Response body_
```
"FORBIDDEN"
```
