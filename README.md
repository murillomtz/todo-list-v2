# Lista de Tarefas

API web para gerenciamento de tarefas e usuários. O código inclui operações de tarefas, autenticação, sessão e compartilhamento de tarefas entre usuários.

## Tecnologias principais

- Java
- Spring Boot
- Spring Security
- Maven
- Persistência relacional via Spring Data JPA

## Executar

É necessário ter um JDK compatível com o projeto e Maven. O repositório inclui Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`.

A configuração de banco e demais propriedades ficam em `src/main/resources`. Revise-as antes de executar localmente. Este repositório contém a API; não foi localizado um frontend correspondente entre os projetos desta lista.
