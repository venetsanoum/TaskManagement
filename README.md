# TaskManagement

Dependencies
---
* Lombok -> getters/setters
* spring web
* mySQL
* spring security
* JPA

DataBase
---
```mysql -u root -p ```
```CREATE DATABASE task_management;```
```CREATE USER 'task_user'@'localhost' IDENTIFIED BY 'task_password';```
```GRANT ALL PRIVILEGES ON task_management.* TO 'task_user'@'localhost';```

```./mvnw spring-boot:run```

MySQL
---
```sudo service mysql status```
```sudo service mysql start```