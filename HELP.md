# ClassTrack - Attendance and Classroom Management System

Welcome to **ClassTrack**, a comprehensive web-based system designed to streamline attendance tracking and classroom management within educational institutions.

## Introduction

ClassTrack is a secure and robust system that allows administrators, faculty, and students to manage various aspects of a college efficiently. It features role-based access control, ensuring that each user has access to the functionalities they need.

## Project Overview

ClassTrack is a web-based application designed for placement projects at TheKiranAcademy. It aims to simplify attendance recording and tracking for students and faculty, provide efficient course scheduling, and enhance communication between faculty, administrators, and students.

### Objectives and Goals

- Simplify attendance recording and tracking for students and faculty.
- Provide efficient course scheduling and faculty management tools.
- Enhance communication between faculty, administrators, and students.

### Scope of the Project

The project includes features such as user authentication, course scheduling, attendance recording, and faculty profile management. It excludes integration with external systems, advanced analytics, and support for non-academic events.


## Tech Stack

### Languages and Frameworks

- **Java** 21
- **Spring Boot** 3.3.0
- **Spring Security**
- **Spring Validation**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **JPA**


### Tools and Libraries

- **Swagger**
- **OpenAPI**
- **SLF4J**
- **H2 Database**
- **MySQL**
- **Lombok**
- 

### Development Tools

- **IntelliJ IDEA**
- **Maven**
- **Postman**
- **Git**
- **H2 Database Console**


## Features

### Role-Based Access Control

ClassTrack ensures secure and precise access control through distinct roles:

- **Admin**: Full access to all modules and features.
- **Faculty**: Manage courses, faculty attendances, and class schedules.
- **Student**: View courses and subjects.

### Logging

Robust logging using SLF4J for better debugging and tracking.

### API Documentation

Comprehensive API documentation generated using Swagger and OpenAPI. Accessible at `http://localhost:8080/swagger-ui/index.html`.

### User Management

Admins can create and manage user accounts effortlessly.

### Classroom Management

Manage classrooms, including creating, updating, and deleting classroom information. Assign classrooms, subjects, and faculty to classes.

### Course Management

Faculty can manage course details, assignments, and student attendance.

### Attendance Management

Keep track of student attendance efficiently with dedicated tools.

### Secure Access

Utilizes Spring Security to ensure secure access to different parts of the application.

## Project Structure

### Overview of Project Architecture

The project follows a layered architecture pattern, with distinct layers for handling different aspects of functionality and data management.

### Layers Description

1. **Controller Layer**: Responsible for handling incoming HTTP requests, processing them, and returning appropriate responses. Controllers act as the entry point to the application and delegate business logic to the service layer.
2. **Service Layer**: Acts as an intermediary between the controller and the data access layer (DAO). It contains business logic and orchestrates interactions between different parts of the application. Services handle tasks such as validation, data manipulation, and transaction management.
3. **DAO (Data Access Object) Layer**: Responsible for interacting with the database and performing CRUD (Create, Read, Update, Delete) operations on the underlying data. DAOs abstract away the details of database interactions and provide a clean interface for the service layer to work with.

### Responsibilities of Each Layer

- **Controller Layer**:
  - Handle incoming HTTP requests.
  - Validate request parameters and payload.
  - Invoke appropriate methods in the service layer.
  - Format and return HTTP responses.
- **Service Layer**:
  - Implement business logic and rules.
  - Coordinate interactions between controllers and DAOs.
  - Perform data manipulation and transformation.
  - Manage transactions and ensure data integrity.
- **DAO Layer**:
  - Provide CRUD operations for accessing and modifying data.
  - Translate database queries and commands into appropriate SQL statements.
  - Handle database transactions and connections.
  - Abstract away database-specific details from the service layer.

## Endpoints

### Course Endpoints

- **GET /api/courses**: Get all courses.
- **GET /api/courses/{id}**: Get a specific course by ID.
- **POST /api/courses**: Create a new course.
- **PUT /api/courses/{id}**: Update an existing course.
- **DELETE /api/courses/{id}**: Delete a course by ID.


### Faculty Endpoints

- **GET /api/faculties**: Get all faculties.
- **GET /api/faculties/{id}**: Get a specific faculty by ID.
- **POST /api/faculties**: Create a new faculty.
- **PUT /api/faculties/{id}**: Update an existing faculty.
- **DELETE /api/faculties/{id}**: Delete a faculty by ID.

### Subject Endpoints

- **GET /api/subjects**: Get all subjects.
- **GET /api/subjects/{id}**: Get a specific subject by ID.
- **POST /api/subjects**: Create a new subject.
- **PUT /api/subjects/{id}**: Update an existing subject.
- **DELETE /api/subjects/{id}**: Delete a subject by ID.

To explore all the endpoints in detail, visit the [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) 
after starting application.

### Admin Endpoints for Adding and Deleting Users

#### Add User Endpoint

- **POST /api/admin/addusers**

  Add a new user with username, password, and role.
- Note: role can be FACULTY, STUDENT not ADMIN

  **Request Body:**
  ```json
  {
    "username": "newUser",
    "password": "password",
    "role": "STUDENT"
  }
  
#### Delete User Endpoint

- **DELETE /api/admin/deleteuser/{username}**

  Delete a user by path variable username.
- e.g. /api/admin/deleteuser/username

## Database Schema

### Tables

- **Classroom**: Stores information about classrooms, including ID, name, capacity, and availability.
- **ClassSchedule**: Represents class schedules, including ID, date, time, classroom ID, course ID, and faculty ID.
- **Course**: Contains details about academic courses, such as ID, name, description, department ID, and credit hours.
- **Department**: Stores information about academic departments, including ID, name, and description.
- **Faculty**: Represents faculty members, including ID, name, email, department ID, and contact information.
- **Subject**: Contains details about academic subjects, such as ID, name, description, and department ID.
- **Faculty Attendance**: Stores attendance records for faculty members in relation to specific class schedules.

## Running the Project

### Prerequisites

- **Java** 21
- **Maven** 3.x
- **MySQL** 8.x (Optional) or **H2 in-memory database** included in the project.

### Steps to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/TheKiranAcademy/classtrack.git
   cd classtrack

2. **update the application.properties file (Optional)**:
   ```bash
   src/main/resources/application.properties
   
3. **Build the project**:
   ```bash
   mvn clean install
   
4. **Run the application**:
   ```bash
    mvn spring-boot:run
   
5. **Access the application**:
   - Open a web browser and go to [http://localhost:8080/home](http://localhost:8080/home)
6. **Postman**:
   - use postman to test the api's with following credentials:
   - **Admin**
     - Username: `admin`
     - Password: `admin`
   - **Faculty**
     - Username: `faculty`
     - Password: `faculty`
   - **Student**
     - Username: `student`
     - Password: `student`
7. **Access the API documentation**:
   - Open a web browser and go to [http://localhost:8080/swagger-ui/index.html]
   (http://localhost:8080/swagger-ui/index.html) and explore the API documentation.
8. **Access the H2 Database Console**:
   - Open a web browser and go to [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - Use the following JDBC URL: `jdbc:h2:mem:classtrack`
   - Connect to the database and explore the tables and data.
- **Note**: The H2 in-memory database is used by default. If you want to use MySQL, update the `application.properties` file with the MySQL database configuration.

10. **Admin Endpoints for Adding and Deleting Users**:
   - Use the provided endpoints to add and delete users with different roles.
   - Refer to the API documentation for more details on the endpoints.