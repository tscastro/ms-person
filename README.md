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
[{"id": 1, "name": "Patricia", "creditLimit": 1, "risk": "A", "shortAddress": "Street", "rate": 0}]
```

### Update

```
http://localhost:8080/update?id=1&name=Carla&creditLimit=200&risk=B&shortAddress=Endereco%20%20Update%2066&rate=10
```

JSON Response:

```json
[{"id": 1, "name": "Carla", "creditLimit": 200, "risk": "B", "shortAddress": "Endereco  Update 66", "rate": 10}]
```

Edit
--------

Use Eclipse or above.

Generate all Eclipse files with Gradle.

```sh
./gradlew eclipse
```
