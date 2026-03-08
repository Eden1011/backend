# Backend API

A REST API for managing products with attributes across multiple producers.

## Tech Stack

Tools used: `Java 21`, `Spring Boot` (+ `JPA`, `Hibernate`, `H2`), `Liquibase`, DTO Mapping via `MapStruct`, `Maven` as the build tool, and `pre-commit` with `spotless` that runs `google-java-format` for code style and formatting.

## Running the Application

**Prerequisites:** Java 21+

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

## Design Notes

Products can have from a few to hundreds of attributes depending on type, as requested.

Attributes are stored as typed key/value pairs in a separate `product_attribute_values` table, referencing a shared `attribute_types` dictionary, which avoids wide tables and means adding new attribute types requires no schema changes.

The service layer returns model entities rather than DTOs. Mapping to response DTOs happens in the controller layer via `MapStruct`, which leaves the layer with only simple logic (de-coupled).

Cascade deletes are handled at the ORM level (`orphanRemoval = true` on all `@OneToMany` relationships), so deleting a producer removes its products, and deleting a product removes its attribute values.

The code is structured by feature. Everything related to `products` lives under `feature/products/`, and so on.

## API

Base path: `/api/v1`, with no security applied.

### Products

| Method   | Endpoint Path               | Operation                                        |
| -------- | --------------------------- | ------------------------------------------------ |
| `GET`    | `/products`                 | List all products                                |
| `GET`    | `/products?name={query}`    | Search by name (case-insensitive, partial match) |
| `GET`    | `/products/{id}`            | Get a single product                             |
| `POST`   | `/products`                 | Create a product                                 |
| `PUT`    | `/products/{id}`            | Update a product (full replacement)              |
| `DELETE` | `/products/{id}`            | Delete a product                                 |
| `GET`    | `/products/{id}/attributes` | List attributes for a product                    |

### Producers

| Method   | Endpoint Path             | Operation             |
| -------- | ------------------------- | --------------------- |
| `GET`    | `/producers`              | List all producers    |
| `GET`    | `/producers?name={query}` | Search by name        |
| `GET`    | `/producers/{id}`         | Get a single producer |
| `POST`   | `/producers`              | Create a producer     |
| `DELETE` | `/producers/{id}`         | Delete a producer     |

### Attribute Types

| Method | Endpoint Path           | Operation                   |
| ------ | ----------------------- | --------------------------- |
| `GET`  | `/attribute-types`      | List all attribute types    |
| `GET`  | `/attribute-types/{id}` | Get a single attribute type |
| `POST` | `/attribute-types`      | Create an attribute type    |

## Error handling

Includes custom `BusinessExceptions` coupled with `BusinessExceptionReason` (Enums), which services throw.

The global API exception handler catches these errors during runtime inside the controllers.
