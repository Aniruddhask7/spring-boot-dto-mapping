# Spring Boot DTO CRUD

A Student CRUD REST API built using Java, Spring Boot, Spring Data JPA, Hibernate, and Oracle Database. This project focuses on understanding Data Transfer Objects (DTOs), request and response DTOs, entity mapping, and REST API development.

## About the Project

This project demonstrates how to implement CRUD (Create, Read, Update, Delete) operations for student records using a layered architecture.

It uses DTOs to transfer data between the client and the application, keeping the API request and response structures separate from the database entity.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Oracle Database
- Maven
- IntelliJ IDEA
- Postman
- Docker

## Project Structure

```text
SpringDTOExample/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── in/spring/
│   │   │       ├── controller/
│   │   │       │   └── studentController.java
│   │   │       ├── dto/
│   │   │       │   ├── CreatestudentRequestDto.java
│   │   │       │   ├── CreatestudentResponseDto.java
│   │   │       │   ├── UpdatestudentRequestDto.java
│   │   │       │   └── UpdatestudentResponseDto.java
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       ├── repository/
│   │   │       │   └── studentRepository.java
│   │   │       ├── service/
│   │   │       └── SpringDtoExampleApplication.java
│   │   └── resources/
│   └── test/
├── Dockerfile
├── pom.xml
└── README.md
```

## Key Concepts Learned

- **DTO (Data Transfer Object):** Transfers data between the client and application without directly exposing the entity.
- **Request DTO:** Accepts data sent by the client when creating or updating a student.
- **Response DTO:** Returns selected student information to the client.
- **Entity:** Represents the student database table.
- **Repository:** Performs database operations using Spring Data JPA.
- **Service Layer:** Contains application logic and coordinates database operations.
- **Controller:** Handles HTTP requests and returns API responses.

## API Operations

Base URL: `http://localhost:8081/api/student`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/create` | Create a student |
| GET | `/get/{id}` | Retrieve a student by ID |
| PUT | `/update/{id}` | Update a student |

## Example API Request

### Create Student

**POST** `/api/student/create`

Example request body:

```json
{
  "name": "Rahul",
  "email": "rahul@example.com",
  "age": 21,
  "subject": "Java"
}
```

The actual request fields depend on your `CreatestudentRequestDto`.

## Database

This project uses Oracle Database with Spring Data JPA and Hibernate for persistence.

Configure your Oracle database connection in `src/main/resources/application.properties` before running the application.

Do not commit database passwords or other sensitive configuration to GitHub.
 

## Learning Objective

The main objective of this project is to understand how DTOs work in a Spring Boot application, how request and response DTOs differ from entities, and how to implement REST APIs using controller, service, and repository layers.

## Author

~Aniruddha
