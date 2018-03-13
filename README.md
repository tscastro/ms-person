Spring Boot com Spring-data, H2 e Swagger
========================================

Java 8 é necessário para rodar esse exemplo.

Clone
--------

```sh
git clone https://github.com/domaframework/spring-boot-sample.git
```

Run
--------

```sh
cd ms-person
```

```sh
./gradlew bootRun
```

Access
--------

### Select

```
http://localhost:8080/swagger-ui.html
```

JSON Response:

```json
[{"id":1,"name":"Vico"},{"id":2,"name":"Ceolin"},{"id"Bolão"}]
```

### Update

```
http://localhost:8080/update?name=Ceolin
```

JSON Response:

```json
[{"id":1,"name":"Ceolin"},{"id":2,"name":"Ceolin"},{"id":3,"name":"Bolão"}]
```

Edit
--------

Use Eclipse or above.

Generate all Eclipse files with Gradle.

```sh
./gradlew eclipse
```
