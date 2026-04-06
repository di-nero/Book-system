# Book System

A Spring Boot REST API for managing students, teachers and courses.

## Technologies
- Java 17
- Spring Boot 3
- MySQL
- JPA/Hibernate
- Lombok

## Relationships
- One-to-Many: Teacher → Course
- Many-to-One: Course → Teacher
- Many-to-Many: Student ↔ Course
- One-to-One: Student → StudentProfile

## Endpoints
### Students
- POST /api/students
- GET /api/students
- GET /api/students/{id}
- PUT /api/students/{id}
- DELETE /api/students/{id}
- POST /api/students/{id}/enroll/{courseId}
- DELETE /api/students/{id}/drop/{courseId}

### Teachers
- POST /api/teachers
- GET /api/teachers
- GET /api/teachers/{id}
- PUT /api/teachers/{id}
- DELETE /api/teachers/{id}
- PUT /api/teachers/{id}/activate

### Courses
- POST /api/courses
- GET /api/courses
- PUT /api/courses/{id}
- GET /api/courses/{id}/students