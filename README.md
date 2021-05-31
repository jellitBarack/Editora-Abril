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


## Sobre o projeto
# Acessando a Documentação
```
http://localhost:8080/swagger-ui.html
```


### Exercicio 01
`User Controller`
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
`Pessoa Controller`
