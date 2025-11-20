# CRUD Backend 

**Spring Boot 3 • Java 17 • Liquibase • PostgreSQL 18** 

A simple and extensible CRUD backend built with Spring Boot 3, using Liquibase for database versioning, and PostgreSQL 18 as the primary database. The project also includes Swagger/OpenAPI for API documentation and testing.

--- 

## 🚀 Features 
- CRUD operations using Spring Boot 3
- Database version control with Liquibase
- PostgreSQL 18 schema
- Centralized configuration in application.properties
- Swagger UI for API definition and testing
- Maven-based project

--- 

## 🛠️ Technologies Used 
- Java 17
- Spring Boot 3
- Liquibase
- PostgreSQL 18
- Maven
- Swagger / Springdoc OpenAPI

--- 

## 📂 Project Structure 

src/  <br>
└── main/  <br>
├── java/...  <br>
├── resources/  <br>
│ ├── db/changelog/ (Liquibase changelogs)  <br>
│ └── application.properties <br>

--- 

## ⚙️ Setup Instructions 

### 1. Create the Database Create a PostgreSQL database named: crud_db 

### 2. Configure Application Properties 

Update: src/main/resources/application.properties with your PostgreSQL settings: 

spring.datasource.url=jdbc:postgresql://localhost:5432/crud_db

spring.datasource.username=YOUR_USERNAME 

spring.datasource.password=YOUR_PASSWORD 

spring.liquibase.change-log=classpath:db/changelog/db.changelog-master.yaml 

--- 

## ▶️ Run the Application Run using Maven: mvn spring-boot:run

--- 

## 📘 API Documentation (Swagger) 

Once the app is running, open: http://localhost:8080/swagger-ui.html or: http://localhost:8080/swagger-ui/index.html 

Use Swagger UI to test APIs and view request/response schemas. 

---


