BookSystem - School Management API

A RESTful API built with Spring Boot for managing students, teachers, and courses in a school system.

Live Demo
Base URL: https://book-system-3.onrender.com

API Documentation: https://documenter.getpostman.com/view/37076417/2sBXqDsNvm


Tech Stack
- Java 17
- Spring Boot 
- PostgreSQL
- JPA / Hibernate
- Lombok
- Docker



Entity Relationships
| Relationship | Entities |
| One-to-Many | Teacher → Course |
| Many-to-One | Course → Teacher |
| Many-to-Many | Student ↔ Course |
| One-to-One | Student → StudentProfile |



API Endpoints

Teachers
| Method | Endpoint | Description |
| POST | `/api/teachers` | Create a teacher |
| GET | `/api/teachers` | Get all teachers |
| GET | `/api/teachers/{id}` | Get a teacher by ID |
| PUT | `/api/teachers/{id}` | Update a teacher |
| PUT | `/api/teachers/{id}/activate` | Activate a teacher |
| DELETE | `/api/teachers/{id}` | Deactivate a teacher |

Courses
| Method | Endpoint | Description |
| POST | `/api/courses` | Create a course |
| GET | `/api/courses` | Get all courses |
| PUT | `/api/courses/{id}` | Update a course |
| GET | `/api/courses/{id}/students` | Get students in a course |

Students
| Method | Endpoint | Description |
| POST | `/api/students` | Create a student + profile |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get a student by ID |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |
| POST | `/api/students/{id}/enroll/{courseId}` | Enroll in a course |
| DELETE | `/api/students/{id}/drop/{courseId}` | Drop a course |


Setup & Installation

Prerequisites
- Java 17
- PostgreSQL
- Maven

Clone the repository
bash
git clone https://github.com/di-nero/Book-system.git
cd Book-system

### Configure environment variables
Create an `application.properties` file in `src/main/resources/`:
properties
spring.datasource.url=jdbc:postgresql://localhost:5432/booksystem
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


Run the application
bash
./mvnw spring-boot:run

Sample Request

Create a Student
json
POST /api/students
{
    "name": "Alice Johnson",
    "email": "alice@gmail.com",
    "studentProfile": {
        "dateOfBirth": "2001-05-14",
        "address": "12 Lagos Street, Ikeja",
        "phoneNumber": "08012345678"
    }
}
