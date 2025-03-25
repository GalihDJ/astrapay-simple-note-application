# Spring Boot Astrapay - Simple Notes Project
A simple RESTful API project to create, read, and delete note written in Java Spring Boot.

#### Author Information:  
- Galih Damar Jati

## Prerequisites
- Java 17+
- Maven 3.8+
- Postman (for API testing) https://www.postman.com/downloads/
- Intellij https://www.jetbrains.com/idea/download/

## Getting Started (How to Run the Program)

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.


* Clone the repository and navigate to the project directory.
```bash
   git clone https://github.com/your-username/astrapay-spring-boot-external.git
```


* To build and run enter the command below:
```bash
   mvn spring-boot:run
```

* Alternate way is to naviage to SimpleNoteApplication.java and click the green arrow or by pressing Ctrl+Shift+F10 on Windows
![img.png](screenshots/img.png)


* API will be available at the URL below
```bash
   http://localhost:8080/api/simple-note
```

## Testing API with Postman

* To test the APIs with Postman you need to import the Postman collection provided to your Postman
  https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-data/


* GET
![GET.png](screenshots/GET.png)


* POST
![POST.png](screenshots/POST.png)


* DELETE
![DELETE.png](screenshots/DELETE.png)


* Input validation result for title longer than 100 characters
![noteTitle Longer Than 100 Characters Validation.png](screenshots/noteTitle%20Longer%20Than%20100%20Characters%20Validation.png)


* Input validation result for content longer than 1000 characters
![noteContent Longer Than 1000 Characters Validation.png](screenshots/noteContent%20Longer%20Than%201000%20Characters%20Validation.png)


* Input validation for blank title
![Input Validation Blank Title.png](screenshots/Input%20Validation%20Blank%20Title.png)


* Input validation for blank content
![Input Validation Blank Content.png](screenshots/Input%20Validation%20Blank%20Content.png)



## Run Unit Test

* To run unit test enter the command below:
```bash
   mvn test
``` 

* Alternate way is to navigate to test java file and click the green arrow or by pressing Ctrl+Shift+F10 on Windows
![img_1.png](screenshots/img_1.png)