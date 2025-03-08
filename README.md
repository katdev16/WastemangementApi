# ♻️ Waste Management API

A **Spring Boot** REST API for waste management that provides information on **waste categories, disposal guidelines, and recycling tips**. This project helps users understand how to **dispose of waste responsibly**.

## 🚀 Features

- 📂 **Manage waste categories** (Add, View, Update, Delete, lookup)
- ♻️ **Get disposal guidelines & recycling tips**
- 📄 **OpenAPI documentation with Swagger UI**
- 🛠️ **Built with Spring Boot, H2 Database, and Spring Data JPA**
- 🐳 **Docker support**

---

## 🏗️ **Tech Stack**

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Swagger UI**
- **Docker**

---

## 🔧 **Setup & Running the Application**

### 1️⃣ Clone the Repository  
```sh
git clone https://github.com/yourusername/waste-management-api.git
cd waste-managementApi/server
```

2️⃣ Build the Application

Ensure you have Java 17 and Maven installed, then run:

```sh
mvn clean package
```
3️⃣ Run the Application Locally
```
mvn spring-boot:run
```
The API will be available at:
http://localhost:8080

4️⃣ Access Swagger API Docs
Once the app is running, open:
👉 http://localhost:8080/swagger-ui.html

🐳 Run with Docker
1️⃣ Build the Docker Image
```sh
docker build -t waste-management .
```
2️⃣ Run the Container
```sh
docker run -p 8080:8080 waste-management
```
The API will now be running inside a Docker container.
<h2>🛠️ API Endpoints</h2>
<table border="1">
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>GET</td>
            <td>/api/waste-categories/{id}</td>
            <td>Get a waste category</td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/api/waste-categories</td>
            <td>List all waste categories</td>
        </tr>
        <tr>
            <td>POST</td>
            <td>/api/waste-categories</td>
            <td>Add a new waste category</td>
        </tr>
        <tr>
            <td>PUT</td>
            <td>/api/waste-categories/{id}</td>
            <td>Update a waste category</td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td>/api/waste-categorie/{id}</td>
            <td>Delete a waste category</td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/api/waste-categorie/lookup/name=""</td>
            <td>Search for category by name</td>
        </tr>
    </tbody>
</table>

Project Structure
 ```sh
├── Dockerfile
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       ├── Api
│   │   │       └── enviro
│   │   │           └── assessment
│   │   │               └── grad001
│   │   │                   └── KatlegoDhlamini
│   │   │                       ├── Config
│   │   │                       │   └── TestConfig.java
│   │   │                       ├── Controller
│   │   │                       │   └── WasteCategoryController.java
│   │   │                       ├── Entity
│   │   │                       │   └── WasteCategory.java
│   │   │                       ├── Exceptions
│   │   │                       │   ├── GlobalExceptionHandler.java
│   │   │                       │   ├── InvalidInputException.java
│   │   │                       │   └── ResourceNotFoundException.java
│   │   │                       ├── Repo
│   │   │                       │   └── WasteRepository.java
│   │   │                       ├── ServerApplication.java
│   │   │                       └── Services
│   │   │                           └── WasteCategoryService.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               ├── Api
│               └── enviro
│                   └── assessment
│                       └── grad001
│                           └── KatlegoDhlamini
│                               ├── Controller
│                               │   └── WasteCategoryControllerTest.java
│                               ├── Entity
│                               │   └── WasteCategoryTest.java
│                               ├── ServerApplicationTests.java
│                               └── Services
│                                   └── WasteCategoryServiceTest.java
└── target
    ├── classes
    │   ├── application.properties
    │   └── com
    │       └── enviro
    │           └── assessment
    │               └── grad001
    │                   └── KatlegoDhlamini
    │                       ├── Config
    │                       │   └── TestConfig.class
    │                       ├── Controller
    │                       │   └── WasteCategoryController.class
    │                       ├── Entity
    │                       │   └── WasteCategory.class
    │                       ├── Exceptions
    │                       │   ├── GlobalExceptionHandler.class
    │                       │   ├── InvalidInputException.class
    │                       │   └── ResourceNotFoundException.class
    │                       ├── Repo
    │                       │   └── WasteRepository.class
    │                       ├── ServerApplication.class
    │                       └── Services

```

🤝 Contributing
<br>
We welcome contributions! To contribute:
<br>
Fork the repository
<br>
Create a new branch (git checkout -b feature-name)
<br>
Make your changes and commit (git commit -m "Add feature X")
<br>
Push the branch (git push origin feature-name)
<br>
Create a Pull Request 🚀
<br>
📜 License
<br>
This project is licensed under the MIT License.


