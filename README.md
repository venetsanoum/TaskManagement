# Task Management Backend

A backend application for managing projects, tasks, users, and project memberships, developed with **Java and Spring Boot**.

The project is currently under development. The implemented functionality so far focuses on authentication, project management, task management, and project member management.

## Technologies

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Spring Security
* JWT Authentication
* MySQL
* Lombok
* Maven
* Git

## Current Features

### Authentication

* User registration
* Password hashing using BCrypt
* User authentication
* JWT token generation
* Spring Security authentication

### Project Management

* Create projects
* Retrieve all projects
* Retrieve a project by ID
* Update project information
* Delete projects

### Project Members

* Retrieve all members of a project
* Add a user to a project
* Remove a user from a project

### Task Management

* Create tasks for a project
* Retrieve all tasks belonging to a project
* Update task information
* Update task status
* Delete tasks
* Assign tasks to users
* Support for task priority and due dates

## Project Structure

The application follows a layered architecture:

```text
src/main/java/com/example/task_management/
│
├── controllers/
│
├── services/
│   ├── AuthService.java
│   ├── ProjectService.java
│   └── TaskService.java
│
├── repositories/
│
├── entities/
│
├── dto/
│   └── response/
│
├── mappers/
│
└── security/
    └── JWTService.java
```

### Services

The business logic is separated into service classes:

* `AuthService` — handles registration and authentication.
* `ProjectService` — handles project CRUD operations and project membership.
* `TaskService` — handles task creation, retrieval, modification, status updates, and deletion.

## API Functionality

The current service layer supports operations corresponding to endpoints such as:

| Method | Endpoint                              | Description         |
| ------ | ------------------------------------- | ------------------- |
| POST   | `/api/projects`                       | Create a project    |
| GET    | `/api/projects`                       | Get all projects    |
| GET    | `/api/projects/{id}`                  | Get a project       |
| PUT    | `/api/projects/{id}`                  | Update a project    |
| DELETE | `/api/projects/{id}`                  | Delete a project    |
| GET    | `/api/projects/{id}/members`          | Get project members |
| POST   | `/api/projects/{id}/members/{userId}` | Add a member        |
| DELETE | `/api/projects/{id}/members/{userId}` | Remove a member     |

Task-related functionality includes creating tasks within a project, retrieving a project's tasks, updating tasks, changing task status, and deleting tasks.

## Authentication

The application uses **Spring Security** together with **JWT-based authentication**.

During registration, passwords are hashed using BCrypt before being stored in the database.

During login, the provided credentials are authenticated through Spring Security. If authentication succeeds, the application generates a JWT containing the authenticated user's username.

## Data Access

The application uses **Spring Data JPA** and **Hibernate** for database access.

Repositories are responsible for communication with the database, while services contain the application's business logic.

DTOs and mapper classes are used to control the data returned by the API instead of directly exposing entity objects in responses.

## Development Status

This project is **currently under development**.

The current implementation includes the core service-layer functionality for:

* Authentication
* Projects
* Tasks
* Project members
* JWT authentication
* Database persistence

Additional functionality, validation, error handling, authorization rules, testing, and other improvements may be added as development continues.

