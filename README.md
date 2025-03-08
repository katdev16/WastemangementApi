# ♻️ Waste Management API

A **Spring Boot** REST API for waste management that provides information on **waste categories, disposal guidelines, and recycling tips**. This project helps users understand how to **dispose of waste responsibly**.

## 🚀 Features

- 📂 **Manage waste categories** (Add, View, Update, Delete)
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
cd waste-management-api
'''

2️⃣ Build the Application
'''sh
Ensure you have Java 8 and Maven installed, then run:
'''
sh
Copy
Edit
mvn clean package
3️⃣ Run the Application Locally
sh
Copy
Edit
mvn spring-boot:run
The API will be available at:
http://localhost:8080

4️⃣ Access Swagger API Docs
Once the app is running, open:
👉 http://localhost:8080/swagger-ui.html

🐳 Run with Docker
1️⃣ Build the Docker Image
sh
Copy
Edit
docker build -t waste-management .
2️⃣ Run the Container
sh
Copy
Edit
docker run -p 8080:8080 waste-management
The API will now be running inside a Docker container.

🛠️ API Endpoints
Method	Endpoint	Description
GET	/waste/{id}	Get a waste category
GET	/waste	List all waste categories
POST	/waste	Add a new waste category
PUT	/waste/{id}	Update a waste category
DELETE	/waste/{id}	Delete a waste category
🤝 Contributing
We welcome contributions! To contribute:

Fork the repository
Create a new branch (git checkout -b feature-name)
Make your changes and commit (git commit -m "Add feature X")
Push the branch (git push origin feature-name)
Create a Pull Request 🚀
📜 License
This project is licensed under the MIT License.


