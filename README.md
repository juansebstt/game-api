# Game Service API

This project is a Spring Boot application that provides a REST API for managing a collection of games. It uses PostgreSQL for database storage, integrates JPA for persistence, and implements common CRUD operations for game data. The API supports features like exception handling and input validation.

## Features

- **Create, Read, Update, Delete (CRUD) Operations** for games.
- REST API with endpoints to manage games.
- PostgreSQL as the database.
- Exception handling via `GameException`.
- API documentation available through Swagger UI.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.3**
    - Spring Web
    - Spring Data JPA
    - Spring Data REST
- **PostgreSQL**
- **Swagger UI** for API documentation
- **Lombok** to reduce boilerplate code
- **JWT** for token management (if needed for future authentication)

## Prerequisites

- **Java 17** or higher
- **PostgreSQL** installed and running
- **Maven** for building the project
- **Postman** or any REST client for testing API endpoints

## Setup Instructions

1. **Clone the repository**:
    
    ```bash
    git clone <https://github.com/your-username/game-service.git>
    cd game-service
    
    ```
    
2. **Configure PostgreSQL**:
    - Update `application.yaml` with your PostgreSQL credentials.
    
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/db
        username: your-username
        password: your-password
    
    ```
    
3. **Build the application**:
    
    ```bash
    mvn clean install
    
    ```
    
4. **Run the application**:
    
    ```bash
    mvn spring-boot:run
    
    ```
    
5. **Access the API documentation**:
    - Once the server is running, open the following link to access the Swagger UI for API documentation.
    
    ```
    <http://localhost:8080/swagger-ui/index.html>
    
    ```
    

## API Endpoints

### Base URL

http://localhost:8080/v1/games

### Endpoints

- **GET /v1/games**: Retrieves a list of all games.
- **POST /v1/games**: Adds a new game to the database.
- **GET /v1/games/{id}**: Retrieves a specific game by its ID.
- **PUT /v1/games/{id}**: Updates an existing game by its ID.
- **DELETE /v1/games/{id}**: Deletes a game by its ID.

## Example Usage

### POST a new game

```
POST /v1/games
Content-Type: application/json
Body:
{
  "name": "The Witcher 3"
}

GET all games

GET /v1/games

GET game by ID

GET /v1/games/1

Update a game by ID

PUT /v1/games/1
Content-Type: application/json
Body:
{
  "name": "The Witcher 3: Wild Hunt"
}


Delete a game by ID

DELETE /v1/games/1

Exception Handling
Custom exceptions are handled using the GameException class.
Errors are logged, and meaningful error responses are returned using the ErrorResponse class.
Contribution
If you want to contribute to this project, feel free to submit a pull request or open an issue.

Created by Juan Sebastian Ibarra
```
