# Library
Simple REST Application.
This is an application Restful CRUD API was built on top of:
- JDK 11;
- Spring Boot;
- MySql;
- Maven.
# Run 
1. Download the zip file or clone the repository: 

   git clone hhttps://github.com/MaximRom00/Library.git

2. Create Mysql database. Set username and password in src/main/resources/application.properties file.
 
4. Run this application using maven: Run the app using maven:
```
mvn spring-boot:run
```
The app will start running at http://localhost:8081.

# REST APIs resuests example
```
POST localhost:8081/api/library
{
        "book":{
            "name":"The Little Prince",
            "year":1943,
            "author":{
                "name":"Exupéry"
            }
        },
        "member":{
            "name":"Petr",
            "telephoneNumber":"6543333"
        },
        "isActive":true
}

GET localhost:8081/api/book (All books)

GET localhost:8081/api/book/{id} (Get book by id)

DELETE localhost:8081/api/author/{id} (Delete book by id)

PUT localhost:8081/api/member (Update member)

 "member":{
            "id" : 1,
            "name":"Petr",
            "telephoneNumber":"6543333"
        },
```
