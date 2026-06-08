# Task Review Service

Spring Boot backend for the `react-ui-learning` app.

## Run it

```bash
mvn spring-boot:run
```

The service starts on:

```text
http://127.0.0.1:8080
```

## Endpoints

```http
GET /tasks
GET /tasks?priority=HIGH
GET /tasks?status=PENDING
GET /tasks?priority=HIGH&status=PENDING
POST /reviews
```

The React app calls this service through `src/shared/api/httpClient.ts`.
