# AutoBG Web Application

**AutoBG** is a web application built with **Spring**, designed for the seamless posting and selling of cars. This platform provides users with a user-friendly interface to list their vehicles and connect with potential buyers.

## Screenshots

### Index page:
![AutoBG Screenshot](/src/main/resources/static/images/app-index.png)

### Login page:
![AutoBG Screenshot](/src/main/resources/static/images/app-login.png)

## Key Features

- **Effortless Listing:** Easily create and manage car listings with our intuitive interface.
- **Advanced Search:** Users can search and filter through a variety of criteria to find their desired vehicles.
- **Responsive Design:** Enjoy a smooth experience across various devices with our responsive design.

## Getting Started

1. **Clone the repository.**

2. **Configure your database settings:**
    - Open `src/main/resources/application.yml`.
    - Update the following properties under `spring.datasource` for MySQL:

      ```yaml
      spring:
        datasource:
          url: jdbc:mysql://localhost:3306/your_database_name
          username: your_username
          password: your_password
          driver-class-name: com.mysql.cj.jdbc.Driver
      ```

3. **Build and run the application:**
    - Use Gradle/Maven or your preferred IDE to build and run the application.

## Technologies Used

- **Spring Framework:** Leveraging the power of Spring for robust backend development.
- **Spring Boot:** Accelerating the development process with convention over configuration and ready-to-use defaults.
- **Thymeleaf:** Dynamic and elegant HTML templates for a seamless user experience.
- **Spring Data Jpa:** Object-relational mapping for efficient database operations.
- **Spring Security:** Ensuring a secure authentication and authorization system for the application.
- **MySQL:** Integrated for efficient data storage and retrieval.
