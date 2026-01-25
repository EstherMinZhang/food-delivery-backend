# Food Delivery Backend System

*(Spring Boot · REST API · MySQL)*

## Project Overview
This project is a backend system for a food delivery platform, built with Spring Boot and designed to simulate real-world business logic such as user management, order processing, and data administration.

The project focuses on backend architecture, RESTful API design, and database interaction, with additional refactoring and feature extensions implemented by me.

## Key Features
- User and employee authentication & authorization  
- Category and dish management (CRUD)  
- Order creation, status tracking, and history  
- RESTful APIs following layered architecture  
- Centralized exception handling  
- Pagination and request validation  
- Integration with MySQL database  

## Tech Stack
- Language: Java  
- Framework: Spring Boot  
- Database: MySQL  
- ORM: MyBatis / MyBatis-Plus  
- Build Tool: Maven  
- API Style: RESTful APIs  
- Tools: IntelliJ IDEA, Git, GitHub  

## System Architecture
The project follows a typical layered backend architecture:

- Controller Layer – handles HTTP requests and responses  
- Service Layer – contains core business logic  
- Persistence Layer – database operations using MyBatis  
- Common Module – constants, utilities, and exception handling  

This structure improves maintainability, scalability, and testability.

## My Contributions
Compared to the initial baseline, I made the following improvements:

- Refactored package structure for better readability  
- Improved API design and naming consistency  
- Added global exception handling  
- Enhanced input validation and error responses  
- Optimized database access logic  
- Wrote clear documentation and comments  

## What I Learned
- Designing and implementing RESTful backend services  
- Structuring a Spring Boot project for real-world use  
- Handling common backend concerns such as validation, exceptions, and pagination  
- Working with relational databases in Java applications  
- Using Git and GitHub for version control and project documentation  

## How to Run
1. Clone the repository  
2. Configure MySQL connection in `application.yml`  
3. Create the database and import schema  
4. Run the Spring Boot application  
5. Access APIs via Postman or browser  

## Notes
This project is a learning-focused backend application created to strengthen my understanding of Java backend development and is not intended for commercial use.

