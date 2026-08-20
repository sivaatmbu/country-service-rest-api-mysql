# 🌍 Country Service REST API — Spring Boot + MySQL

A simple **Spring Boot REST API** project developed to understand REST API development and database integration using **Spring Data JPA**.

This project is an improved version of my earlier Country Service REST API. In the previous version, country data was stored using an in-memory `HashMap`. In this version, the `HashMap` has been replaced with a **MySQL database** using **Spring Data JPA and Repository**.

---

## 🎥 Project Demo

This video demonstrates the execution and working of the Country Service REST API using Spring Boot, Spring Data JPA, MySQL, and Postman.

▶️ **[Watch the Project Demo](https://youtu.be/OoJrC3xFtYg)**

The demo shows the REST API operations being tested using Postman and the corresponding data changes in the database.

---

## 🚀 Features

* Get all countries
* Get a country by ID
* Get a country by name
* Add a new country
* Update an existing country
* Delete a country
* Persistent data storage using MySQL
* Database operations using Spring Data JPA
* REST API testing using Postman

---

## 🛠️ Technologies Used

| Technology        | Purpose                         |
| ----------------- | ------------------------------- |
| Java 17           | Programming Language            |
| Spring Boot 3.5.5 | Backend Framework               |
| Spring Web        | REST API Development            |
| Spring Data JPA   | Database Integration            |
| Hibernate         | ORM Framework                   |
| MySQL / MariaDB   | Database                        |
| MySQL Workbench   | Database Management             |
| Maven             | Build and Dependency Management |
| Postman           | API Testing                     |
| Eclipse           | Development Environment         |

---

## 🏗️ Project Architecture

The project follows a simple layered architecture:

```text
             Client / Postman
                    │
                    ▼
              Controller
                    │
                    ▼
                Service
                    │
                    ▼
               Repository
                    │
                    ▼
             Spring Data JPA
                    │
                    ▼
              MySQL Database
```

### Controller

Handles HTTP requests and exposes the REST API endpoints.

### Service

Contains the application logic and communicates with the Repository.

### Repository

Uses Spring Data JPA to perform database operations.

### Entity

The `Country` class represents the `country` table in the database.

---

## 🗄️ Database

The project uses a database named:

```text
mydb
```

The database contains a table named:

```text
country
```

### Country Table

| Column         | Description     |
| -------------- | --------------- |
| `id`           | Primary key     |
| `country_name` | Country name    |
| `capital`      | Country capital |

### Example Data

| ID | Country Name   | Capital    |
| -: | -------------- | ---------- |
|  1 | INDIA          | DELHI      |
|  2 | USA            | WASHINGTON |
|  3 | UK             | LONDON     |
|  4 | MY Own Country | My capital |

---

## 📁 Database SQL Script

The repository contains the database script:

```text
Database/mydb.sql
```

This file contains the structure and sample data for the `country` table.

You can use this SQL file to recreate the database table and sample records.

---

## 📦 Important Maven Dependencies

### Spring Data JPA

Spring Data JPA is used to connect the application with the relational database and perform database operations through repositories.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

### MySQL Connector

The MySQL Connector is used to establish the database connection from the Spring Boot application.

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## ⚙️ Database Configuration

The application connects to the local database using the following configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> **Note:** The password is intentionally not included in this repository. Configure your own local MySQL/MariaDB credentials in `application.properties`.

---

## 🔄 From HashMap to Database

The earlier version of this project stored country information using:

```java
HashMap<Integer, Country>
```

The current version replaces the in-memory storage with:

```text
Country Entity
      ↓
CountryRepository
      ↓
Spring Data JPA
      ↓
MySQL Database
```

### Previous Version

```text
REST API
   ↓
Service
   ↓
HashMap
```

### Current Version

```text
REST API
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Spring Data JPA
   ↓
MySQL
```

This allows the application to store data persistently instead of keeping it only in application memory.

---

## 🌐 REST API Endpoints

### 1. Get All Countries

```http
GET /getAllCountries
```

Returns all countries stored in the database.

---

### 2. Get Country by ID

```http
GET /getCountryById/{id}
```

Example:

```http
GET /getCountryById/1
```

---

### 3. Get Country by Name

```http
GET /getCountryByName/{countryName}
```

Example:

```http
GET /getCountryByName/INDIA
```

---

### 4. Add a Country

```http
POST /addCountry
```

Example request body:

```json
{
    "id": 5,
    "countryName": "JAPAN",
    "capital": "TOKYO"
}
```

---

### 5. Update a Country

```http
PUT /updateCountry
```

Example request body:

```json
{
    "id": 5,
    "countryName": "JAPAN",
    "capital": "TOKYO"
}
```

---

### 6. Delete a Country

```http
DELETE /deleteCountry/{id}
```

Example:

```http
DELETE /deleteCountry/5
```

---

## 🧪 Testing with Postman

All REST APIs were tested using **Postman**.

The following operations were tested successfully:

* GET all countries
* GET country by ID
* GET country by name
* POST a new country
* PUT/update a country
* DELETE a country

The changes made through the REST API are reflected in the database.

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/sivaatmbu/country-service-rest-api-mysql.git
```

### 2. Open the Project

Open the project in Eclipse, IntelliJ IDEA, or another Java IDE.

### 3. Configure the Database

Make sure MySQL/MariaDB is running.

Create the database:

```sql
CREATE DATABASE mydb;
```

Then execute the SQL script available at:

```text
Database/mydb.sql
```

### 4. Configure Database Credentials

Open:

```text
src/main/resources/application.properties
```

Update the username and password according to your local database configuration.

### 5. Run the Application

Run the Spring Boot main application class:

```text
SpringBootCountryServiceProjectApplication1Application
```

The application runs on:

```text
http://localhost:8080
```

### 6. Test Using Postman

Use the REST API endpoints listed above to test the application.

---

## 📂 Project Structure

```text
SpringBootCountryServiceProjectApplication-1
│
├── Database
│   └── mydb.sql
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.countryService.demo
│   │   │       ├── Beans
│   │   │       │   ├── Country.java
│   │   │       │   └── Message.java
│   │   │       │
│   │   │       ├── Controllers
│   │   │       │   └── CountryController.java
│   │   │       │
│   │   │       ├── Repositories
│   │   │       │   └── CountryRepository.java
│   │   │       │
│   │   │       ├── Services
│   │   │       │   └── CountryService.java
│   │   │       │
│   │   │       └── SpringBootCountryServiceProjectApplication1Application.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── .gitignore
├── pom.xml
├── mvnw
└── mvnw.cmd
```

---

## 📚 What I Learned

Through this project, I learned and practiced:

* Creating REST APIs using Spring Boot
* Working with HTTP methods
* Using `@RestController`
* Using `@GetMapping`, `@PostMapping`, `@PutMapping`, and `@DeleteMapping`
* Using `@PathVariable`
* Creating a Service layer
* Creating a Repository layer
* Using Spring Data JPA
* Connecting Spring Boot with MySQL/MariaDB
* Mapping Java entities to database tables
* Performing CRUD operations with a database
* Understanding ORM using Hibernate
* Testing REST APIs using Postman
* Replacing in-memory `HashMap` storage with persistent database storage

---

## 🔮 Future Improvements

Some possible improvements for this project:

* Add exception handling
* Add input validation
* Implement DTOs
* Add global exception handling using `@ControllerAdvice`
* Add pagination and sorting
* Add unit and integration testing
* Add Swagger/OpenAPI documentation
* Add authentication and authorization

---

## 👨‍💻 Author

**Siva Praneesh**

B.Tech – Computer Science and Engineering (Data Science)

---

## 📄 License

Copyright © 2026 Siva Praneesh Velpula. All rights reserved.

This project is created for learning and educational purposes.
