# Car Repair Management API (Conserto Carros API)

A Spring Boot REST API for managing car repairs in a workshop. This application allows tracking of vehicle repairs, including entry and exit dates, responsible mechanics, and vehicle details.

## Technologies Used

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Data JPA** - For database access and ORM
- **Spring Validation** - For input validation
- **H2 Database** - Embedded database for data storage
- **Flyway** - For database migrations
- **Lombok** - For reducing boilerplate code
- **Maven** - For dependency management and build

## Features

- Create, read, update, and delete car repair records
- Track repair entry and exit dates
- Manage mechanic information (name, years of experience)
- Store vehicle details (brand, model, year, color)
- Soft delete functionality (marking records as inactive)
- Pagination support for listing repairs

## Setup Instructions

1. Ensure you have Java 21 installed
2. Clone this repository
3. Build the project using Maven:
   ```
   ./mvnw clean install
   ```
4. Run the application:
   ```
   ./mvnw spring-boot:run
   ```
5. The API will be available at `http://localhost:8080`
6. H2 Console is available at `http://localhost:8080/h2-console` with the following settings:
   - JDBC URL: `jdbc:h2:file:./DATA/conserto-api`
   - Username: `sa`
   - Password: (leave empty)

## API Endpoints

### Repair Management

- **POST /consertos** - Create a new repair record
- **GET /consertos** - List all repairs (paginated)
- **GET /consertos/algunsdados** - List active repairs with limited data
- **GET /consertos/{id}** - Get a specific repair by ID
- **PUT /consertos** - Update a repair record
- **DELETE /consertos/{id}** - Soft delete a repair record (marks as inactive)

## Database Schema

The application uses a single table `consertos` with the following structure:

- `id` - Primary key, auto-increment
- `data_entrada_oficina` - Date when the vehicle entered the workshop
- `data_saida_oficina` - Date when the vehicle left the workshop
- `nome` - Mechanic's name
- `anos_experiencia` - Mechanic's years of experience
- `marca` - Vehicle brand
- `modelo` - Vehicle model
- `ano` - Vehicle year
- `cor` - Vehicle color
- `ativo` - Active status flag (for soft delete)

## Sample Request

### Creating a new repair

```
POST /consertos
```

```json
{
  "dataEntradaOficina": "2023-06-15",
  "dataSaidaOficina": "2023-06-20",
  "mecanicoResponsavel": {
    "nome": "João Silva",
    "anosExperiencia": 5
  },
  "veiculoResponsavel": {
    "marca": "TOYOTA",
    "modelo": "Corolla",
    "ano": 2020,
    "cor": "Prata"
  }
}
```

## Project Structure

The project follows a standard Spring Boot structure:

- `controller` - REST controllers
- `model` - Domain models and DTOs
- `repository` - Data access interfaces
- `resources/db/migration` - Flyway database migrations
