# Login & Book Management Application

This project is a full-stack application that allows users to register, log in, and manage their personal book collections. It features user authentication and a one-to-many relationship between users and books, enabling users to add, edit, and delete their books.

## Features

- **User Registration and Login**: Users can create an account and log in to access their book collection.
- **Book Management**: Users can add new books, edit existing books, and delete books from their collection.
- **User-Book Relationship**: Each user can manage multiple books, with each book linked to the user who created it.

## Technologies Used

- **Backend**: Java, Spring Boot
- **Frontend**: HTML, CSS, Thymeleaf
- **Database**: H2 Database (or any other relational database)
- **Build Tool**: Maven

## Project Structure

```
login-book-management
├── java-stack
│   └── login
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── example
│       │   │   │           └── login
│       │   │   │               ├── controllers
│       │   │   │               │   ├── HomeController.java
│       │   │   │               │   └── BookController.java
│       │   │   │               ├── models
│       │   │   │               │   ├── User.java
│       │   │   │               │   └── Book.java
│       │   │   │               ├── repositories
│       │   │   │               │   ├── UserRepository.java
│       │   │   │               │   └── BookRepository.java
│       │   │   │               └── services
│       │   │   │                   ├── UserService.java
│       │   │   │                   └── BookService.java
│       │   │   └── resources
│       │   │       ├── static
│       │   │       └── templates
│       │   │           ├── index.html
│       │   │           ├── home.html
│       │   │           ├── addBook.html
│       │   │           ├── editBook.html
│       │   │           └── bookList.html
│       │   └── test
│       │       └── java
│       │           └── com
│       │               └── example
│       │                   └── login
│       │                       └── BookManagementTests.java
│       ├── pom.xml
│       └── README.md
└── README.md
```

## Setup Instructions

1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**: 
   ```
   cd login-book-management/java-stack/login
   ```

3. **Build the Project**: 
   ```
   mvn clean install
   ```

4. **Run the Application**: 
   ```
   mvn spring-boot:run
   ```

5. **Access the Application**: Open your web browser and go to `http://localhost:8080`.

## Contribution

Feel free to fork the repository and submit pull requests for any improvements or features you would like to add. 

## License

This project is licensed under the MIT License.