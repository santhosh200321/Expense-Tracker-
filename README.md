# Expense Tracker Microservices Project

A full-stack backend project for managing personal finances using Spring Boot Microservices architecture. This project includes various services like User, Budget, Transaction, Analysis, Report, and an API Gateway, each running independently and communicating through REST APIs and Feign clients.

## ✨ Tech Stack

- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Cloud Config
- Spring Data JPA
- MySQL
- Spring Cloud Netflix Eureka
- OpenFeign
- Maven

## 📦 Microservices Overview

### 1. **Service Registry**
- **Port:** 8761
- **Tech:** Eureka Server
- **Responsibility:** Service Discovery


### 3. **API Gateway**
- **Port:** 8080
- **Tech:** Spring Cloud Gateway
- **Responsibility:** Routing requests to respective microservices

### 4. **User Service**
- **Port:** 8081
- **Responsibility:** Manage user accounts
- **Endpoints:**
  - `POST /users`
  - `GET /users/{id}`

### 5. **Budget Service**
- **Port:** 8082
- **Responsibility:** Manage user budgets
- **Endpoints:**
  - `GET /budgets`
  - `GET /budgets/user/{userId}`
  - `POST /budgets`
  - `PUT /budgets/{id}`
  - `DELETE /budgets/{id}`

### 6. **Transaction Service**
- **Port:** 8083
- **Responsibility:** Track income/expenses
- **Validates:** User existence and budget limits
- **Endpoints:**
  - `GET /transactions`
  - `POST /transactions`
  - `GET /transactions/user/{userId}`

### 7. **Analysis Service**
- **Port:** 8084
- **Responsibility:** Analyze transaction history (spending per category)
- **Endpoints:**
  - `GET /analysis/user/{userId}`

### 8. **Report Service**
- **Port:** 8085
- **Responsibility:** Generate user financial reports
- **Endpoints:**
  - `GET /report/user/{userId}`

---

## ⚙️ Running the Project

1. **Start MySQL** and create individual databases for each service.
2. **Start Eureka Server** (`service-registry`)
3. **Start Config Server** (`config-server`)
4. **Start all microservices** (User, Budget, Transaction, etc.)
5. **Start API Gateway**

---



## 💡 Future Improvements

- Add Notification Service
- Graphical dashboard frontend (React/Angular)
- Rate limiting via Gateway
- Centralized logging (ELK Stack)

---

## 🧑‍💻 Author

