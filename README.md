Task Manager REST API

A backend Task Management system built using Java, Spring Boot, and MySQL.
This application provides secure REST APIs to manage tasks with authentication and authorization using JWT and Spring Security.

---

🚀 Features

- User registration and login
- JWT-based authentication and authorization
- Create, update, and delete tasks
- Mark tasks as completed
- Filter tasks by status (PENDING / COMPLETED)
- Pagination support for task listing
- User–Task One-to-Many relationship
- Global exception handling
- RESTful API architecture

---

🛠 Tech Stack

Backend

- Java
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)

Database

- MySQL

Tools

- Maven
- Postman
- Git & GitHub

---

📂 Project Structure

src/main/java/com/taskmanager/backend

- controller → Handles API requests
- service → Business logic
- repository → Database interaction
- entity → JPA entities (User, Task)
- security → JWT authentication & security configuration
- dto → Request objects
- exception → Global exception handling

---

🔐 Authentication

The API uses JWT (JSON Web Token) authentication.

Flow:

1. User registers or logs in.
2. Server generates a JWT token.
3. Client sends the token in request headers.

Example:

Authorization: Bearer YOUR_JWT_TOKEN

Protected APIs require this token.

---

📌 API Endpoints

Authentication

POST /api/auth/register
POST /api/auth/login

Tasks

POST /api/users/{userid}/tasks → Create task
GET /api/tasks → Get all tasks (with pagination)
GET /api/tasks/{taskid} → Get task by ID
PUT /api/tasks/{taskid} → Update task
DELETE /api/tasks/{taskid} → Delete task

Task Status

PUT /api/tasks/{taskid}/complete → Mark task completed
GET /api/tasks/status/{status} → Filter tasks by status

---

📊 Database Design

User

- id
- username
- password

Task

- id
- title
- description
- status
- user_id (Foreign Key)

Relationship:

One User → Many Tasks

---

⚙️ How to Run the Project

1. Clone the repository

git clone https://github.com/manum-fullstack/task-manager-api.git

2. Navigate to the project

cd task-manager-api

3. Configure MySQL database in

application.properties

4. Run the project

mvn spring-boot:run

Server will start on

http://localhost:8082

---

🧪 Testing APIs

Use Postman to test APIs.

Steps:

1. Register a user
2. Login to get JWT token
3. Add token in Authorization header
4. Access protected APIs

---

📈 Future Improvements

- Role-based authorization
- Docker containerization
- API documentation using Swagger
- Deployment on cloud (AWS)

---

👨‍💻 Author

Manu M
Java Backend Developer

LinkedIn
https://linkedin.com/in/manu-m-080177317

GitHub
https://github.com/manum-fullstack
