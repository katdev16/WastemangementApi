# ♻️ Waste Management API

A **Spring Boot** REST API for waste management that provides information on **waste categories, disposal guidelines, and recycling tips**. This project helps users understand how to **dispose of waste responsibly**.

## 🚀 Features

- 📂 **Manage waste categories** (Add, View, Update, Delete, lookup)
- ♻️ **Get disposal guidelines & recycling tips**
- 🛠️ **Built with Spring Boot, H2 Database, and Spring Data JPA**
- 🐳 **Docker support**

---

## 🏗️ **Tech Stack**

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
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
            <th>Example Request</th>
            <th>Example Response</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>GET</td>
            <td>/api/waste-categories</td>
            <td>Get all waste categories</td>
            <td><code>curl -X GET http://localhost:8080/api/waste-categories</code></td>
            <td>
                <pre>
[
    {
        "id": 1,
        "name": "Plastic",
        "description": "Recyclable plastic materials"
    },
    {
        "id": 2,
        "name": "Organic Waste",
        "description": "Biodegradable food waste"
    }
]
                </pre>
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/api/waste-categories/{id}</td>
            <td>Get a waste category by ID</td>
            <td><code>curl -X GET http://localhost:8080/api/waste-categories/1</code></td>
            <td>
                <pre>
{
    "id": 1,
    "name": "Plastic",
    "description": "Recyclable plastic materials"
}
                </pre>
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/api/waste-categories/lookup?name=Plastic</td>
            <td>Lookup a category by name</td>
            <td><code>curl -X GET "http://localhost:8080/api/waste-categories/lookup?name=Plastic"</code></td>
            <td>
                <pre>
{
    "id": 1,
    "name": "Plastic",
    "description": "Recyclable plastic materials"
}
                </pre>
            </td>
        </tr>
        <tr>
            <td>POST</td>
            <td>/api/waste-categories</td>
            <td>Add a new waste category</td>
            <td>
                <pre>
curl -X POST http://localhost:8080/api/waste-categories \
-H "Content-Type: application/json" \
-d '{
    "name": "Glass",
    "description": "Recyclable glass materials"
}'
                </pre>
            </td>
            <td>
                <pre>
{
    "id": 3,
    "name": "Glass",
    "description": "Recyclable glass materials"
}
                </pre>
            </td>
        </tr>
        <tr>
            <td>PUT</td>
            <td>/api/waste-categories/{id}</td>
            <td>Update a waste category</td>
            <td>
                <pre>
curl -X PUT http://localhost:8080/api/waste-categories/1 \
-H "Content-Type: application/json" \
-d '{
    "name": "Plastic",
    "description": "Updated description"
}'
                </pre>
            </td>
            <td>
                <pre>
{
    "id": 1,
    "name": "Plastic",
    "description": "Updated description"
}
                </pre>
            </td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td>/api/waste-categories/{id}</td>
            <td>Delete a waste category</td>
            <td><code>curl -X DELETE http://localhost:8080/api/waste-categories/1</code></td>
            <td>
                <pre>
HTTP 204 No Content
                </pre>
            </td>
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

<h2>🚨 Error Handling</h2>
<p>The API returns meaningful error responses with appropriate HTTP status codes when an issue occurs. Below are common errors:</p>

<table border="1">
    <thead>
        <tr>
            <th>Status Code</th>
            <th>Cause</th>
            <th>Example Request</th>
            <th>Example Response</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><strong>400 Bad Request</strong></td>
            <td>Invalid input provided (e.g., missing required fields).</td>
            <td>
                <pre>
curl -X POST http://localhost:8080/api/waste-categories \
-H "Content-Type: application/json" \
-d '{
    "name": ""
}'
                </pre>
            </td>
            <td>
                <pre>
{
    "error": "Category name cannot be empty."
}
                </pre>
            </td>
        </tr>
        <tr>
            <td><strong>404 Not Found</strong></td>
            <td>Requested resource does not exist (e.g., invalid ID).</td>
            <td>
                <pre>
curl -X GET http://localhost:8080/api/waste-categories/999
                </pre>
            </td>
            <td>
                <pre>
{
    "error": "Category with ID 999 not found."
}
                </pre>
            </td>
        </tr>
        <tr>
            <td><strong>500 Internal Server Error</strong></td>
            <td>Unexpected server error.</td>
            <td>
                <pre>
curl -X GET http://localhost:8080/api/waste-categories
                </pre>
            </td>
            <td>
                <pre>
{
    "error": "An unexpected error occurred."
}
                </pre>
            </td>
        </tr>
    </tbody>
</table>

<p><strong>Notes:</strong></p>
<ul>
    <li>All error messages follow a structured JSON format.</li>
    <li>Errors such as missing parameters or invalid input return a <code>400 Bad Request</code> response.</li>
    <li>Invalid or non-existent resources return a <code>404 Not Found</code> response.</li>
    <li>Unexpected errors return a <code>500 Internal Server Error</code> response.</li>
</ul>


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


