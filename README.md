# eCommerce Microservices Project

## Overview
This project is a **Java-based eCommerce application** built using a **microservices architecture**. It is designed to demonstrate how to build scalable, modular, and maintainable applications by dividing the system into loosely coupled services. Each microservice handles a specific business function (e.g., Product Catalog, Inventory, Orders, Payment) and communicates with others over HTTP (REST API) or messaging systems.

## Features
- **Product Management**: CRUD operations for products and categories.
- **Order Management**: Placing, updating, and tracking customer orders.
- **Inventory Service**: Managing stock levels for products.
- **Notification Service**: Sending email/SMS notifications for order status.

## Microservices Architecture
The application is composed of several microservices, each running independently and interacting with one another. Below is a brief description of each service:

### 1. **Product Service**
- **Language**: Java, Spring Boot
- **Responsibilities**: Manages products and categories.
- **Database**: MySQL
- **REST Endpoints**:
    - `GET /products`: Retrieve list of products.
    - `POST /products`: Create a new product.

### 2. **Order Service**
- **Language**: Java, Spring Boot
- **Responsibilities**: Handles order creation, updates, and tracking.
- **Database**: MySQL
- **REST Endpoints**:
    - `POST /orders`: Create a new order.
    - `GET /orders/{orderId}`: Retrieve order details.

### 3. **Inventory Service**
- **Language**: Java, Spring Boot
- **Responsibilities**: Manages product stock levels.
- **Database**: MySQL
- **REST Endpoints**:
    - `GET /inventory/{productId}`: Check stock for a product.
    - `PUT /inventory/{productId}`: Update stock levels for a product.

### 4. **Notification Service**
- **Language**: Java, Spring Boot
- **Responsibilities**: Sends notifications to customers via email or SMS.
- **External APIs**: Integrates with an email/SMS provider (e.g., SendGrid, Twilio).
- **REST Endpoints**:
    - `POST /notifications`: Send notification to the customer.

## Tech Stack
- **Java**: Core programming language.
- **Spring Boot**: Framework used for building microservices.
- **MySQL / PostgreSQL / Redis**: Databases used for different services.
- **RabbitMQ / Kafka**: Messaging system for inter-service communication.
- **Docker**: Containerization for microservices.
- **Kubernetes**: Orchestrating and managing containers (optional).
- **Eureka / Consul**: Service discovery (optional).
- **Zuul / Spring Cloud Gateway**: API gateway for routing requests to the microservices.
- **Hystrix**: Circuit breaker for fault tolerance (optional).
- **Prometheus / Grafana**: Monitoring and observability.

## Prerequisites

Before running the project, ensure the following are installed:
- **Java 11+**
- **Maven 3+**
- **Docker** (for containerized deployment)
- **MySQL** and **PostgreSQL** (or use Dockerized DB instances)
- **RabbitMQ** or **Kafka** (for messaging)

## Installation

### Clone the Repository

```bash
git clone https://github.com/your-username/e-commerce.git
cd e-commerce
