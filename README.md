# Webhook Application – Spring Boot & MySQL

A full-stack webhook receiver application built using **Java, Spring Boot, Spring Data JPA, MySQL, and HTML/CSS/JavaScript**. The application receives webhook events through REST APIs, validates incoming data, stores events in a MySQL database, and displays the received events on a web dashboard.

## Overview

A webhook is a way for one application to automatically send data to another application when a specific event occurs.

This project demonstrates how a backend service can receive event data, validate it, save it in a database, and make the stored events available through REST APIs and a dashboard.

## Features

- **Webhook Event Receiver:** Accepts incoming JSON data through a REST API.
- **Input Validation:** Validates required fields and rejects invalid requests.
- **MySQL Database Integration:** Stores received webhook events using Spring Data JPA.
- **Event Retrieval API:** Retrieves stored events and supports filtering by repository name.
- **Timestamp Tracking:** Records when an event is received.
- **Web Dashboard:** Displays webhook events through a browser-based interface.
- **RESTful APIs:** Uses HTTP methods and JSON for communication between clients and the backend.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot | Application development |
| Spring Web | REST API creation |
| Spring Data JPA | Database operations |
| Hibernate | ORM and entity management |
| MySQL | Persistent event storage |
| HTML, CSS, JavaScript | Frontend dashboard |
| Maven | Dependency management and build |
| Git & GitHub | Version control and project hosting |
| VS Code | Development environment |

## Project Structure

```text
webhookapp/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/example/webhookapp/
│   │   │   ├── WebhookappApplication.java
│   │   │   ├── WebhookController.java
│   │   │   ├── WebhookRequest.java
│   │   │   ├── WebhookResponse.java
│   │   │   ├── WebhookEvent.java
│   │   │   └── WebhookEventRepository.java
│   │   └── resources/
│   │       └── static/
│   │           └── index.html
│   └── test/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

### Important Components

- **WebhookappApplication.java:** Entry point of the Spring Boot application.
- **WebhookController.java:** Handles incoming webhook requests and event retrieval.
- **WebhookRequest.java:** Represents incoming JSON data and defines validation rules.
- **WebhookResponse.java:** Defines the response returned by the API.
- **WebhookEvent.java:** Represents a webhook event stored in the database.
- **WebhookEventRepository.java:** Provides database operations using Spring Data JPA.
- **index.html:** Provides the web dashboard for viewing and interacting with events.

## Prerequisites

Install the following before running the application:

1. Java Development Kit (JDK) 17 or later.
2. MySQL Server 8.x.
3. Visual Studio Code or another Java-compatible IDE.
4. Git (optional, for cloning the repository).

## Installation and Setup

### 1. Clone the Repository

Open a terminal and run:

```bash
git clone https://github.com/Anushka-C05/webhookapp.git
cd webhookapp
```

### 2. Create the MySQL Database

Open MySQL Workbench or the MySQL command line and execute:

```sql
CREATE DATABASE webhookdb;
```

### 3. Configure Database Connection

Create the file `src/main/resources/application.properties` locally.

Add the following configuration and replace the placeholder with your own MySQL password:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/webhookdb
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**Security note:** Keep your actual database password private. The local `application.properties` file is excluded from GitHub, so each developer must configure their own database credentials.

### 4. Run the Application

On Windows, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Wait until the terminal confirms that the Spring Boot application has started.

### 5. Open the Dashboard

Visit:

http://localhost:8080/

The dashboard should load in your browser.

## REST API Documentation

The application exposes the following endpoints.

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/webhook` | Receives, validates, and stores a webhook event |
| `GET` | `/webhook/events` | Retrieves stored events |
| `GET` | `/webhook/events?repository=webhookapp` | Retrieves events filtered by repository |

All URLs below use the local base address `http://localhost:8080`.

### 1. Receive a Webhook Event

**Endpoint:** `POST /webhook`

**Request header:**

```http
Content-Type: application/json
```

**Request body:**

```json
{
  "event": "push",
  "repository": "webhookapp",
  "user": "Anushka"
}
```

**Example using PowerShell:**

```powershell
$body = @{
    event = "push"
    repository = "webhookapp"
    user = "Anushka"
} | ConvertTo-Json

Invoke-RestMethod `
    -Uri "http://localhost:8080/webhook" `
    -Method Post `
    -ContentType "application/json" `
    -Body $body
```

**Example response:**

```json
{
  "message": "Webhook received successfully",
  "event": "push",
  "repository": "webhookapp",
  "user": "Anushka"
}
```

The event is saved in MySQL and can subsequently be retrieved through the event retrieval API.

### 2. Retrieve All Webhook Events

**Endpoint:** `GET /webhook/events`

Example request:

```http
GET http://localhost:8080/webhook/events
```

This endpoint returns the stored webhook events, including their available event details and received timestamps.

### 3. Filter Events by Repository

**Endpoint:** `GET /webhook/events?repository=webhookapp`

Example request:

```http
GET http://localhost:8080/webhook/events?repository=webhookapp
```

This endpoint returns events associated with the specified repository.

### 4. Validate Incoming Data

The application validates required fields before accepting an event.

For example, a request with a missing or blank required field should be rejected.

**Example invalid request:**

```json
{
  "event": "",
  "repository": "webhookapp",
  "user": "Anushka"
}
```

Expected result: `400 Bad Request`.

## How the Application Works

1. A client sends a JSON webhook event to the Spring Boot backend.
2. The controller receives the request.
3. Validation checks that the required fields are present.
4. The application saves the event through Spring Data JPA into MySQL.
5. The API returns a JSON response to the client.
6. The dashboard displays the received events using the backend APIs.

## Future Enhancements

- Integrate with real GitHub webhook deliveries.
- Add webhook signature verification and authentication.
- Implement duplicate-event detection.
- Add pagination and advanced event filtering.
- Add Docker support for consistent deployment.
- Deploy the backend and database to a cloud environment.
- Improve automated testing and error handling.

## Learning Outcomes

This project demonstrates practical experience with:

- Building REST APIs using Spring Boot.
- Working with HTTP methods and JSON requests.
- Applying request validation.
- Integrating MySQL using Spring Data JPA and Hibernate.
- Connecting a frontend dashboard to backend APIs.
- Managing source code with Git and GitHub.

## Author

**Anushka Chaudhari**

GitHub: [Anushka-C05](https://github.com/Anushka-C05)

Project Repository: [webhookapp](https://github.com/Anushka-C05/webhookapp)
