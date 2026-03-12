# DEPENDÊNCIAS MAVEN NECESSÁRIAS PARA SWAGGER/SPRINGDOC-OPENAPI

## Adicione as seguintes dependências ao seu arquivo `pom.xml` na seção `<dependencies>`:

```xml
<!-- SpringDoc OpenAPI (Swagger 3.0) -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.2</version>
</dependency>

<!-- Validation (Jakarta) -->
<dependency>
    <groupId>jakarta.validation</groupId>
    <artifactId>jakarta.validation-api</artifactId>
    <version>3.0.2</version>
</dependency>

<!-- Spring Boot Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Spring Boot Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Lombok (opcional, para reduzir código) -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
```

## Como adicionar ao pom.xml:

1. Abra o arquivo `pom.xml` na raiz do seu projeto
2. Localize a seção `<dependencies>`
3. Cole o código acima dentro dessa seção
4. Salve o arquivo
5. Execute o comando no terminal: `mvn clean install`

Depois de adicionar as dependências e fazer a instalação, você poderá acessar:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs
