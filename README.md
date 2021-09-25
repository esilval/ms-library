# Library App

This simple application shows the way to implement **hexagonal architecture** based in a **library** example.

## Technical stack

* Java (v11.0)
* Maven (v3.6.3)
* Spring Boot (v2.4.5)
* H2 database

## Installing

1. Download the project in a determinate directory

```
git clone https://github.com/esilval/ms-library.git
```

2. Execute maven clean and install artifacts:

```
cd ms-library
mvn clean install
```

3. Go to the `ms-launcher` project and execute the maven run command:

```
mvn spring-boot:run
```

## Execute the endpoints

You can use this context path to access to the service:

```
http://localhost:9090/api/v1/library
```

and use these endpoints to interact with the application:

* Get all books
```
curl --location --request GET 'http://localhost:9090/api/v1/library/books/'
```

* Get a book by id
```
curl --location --request GET 'http://localhost:9090/api/v1/library/books/1'
```

* Create a new book
```
curl --location --request POST 'http://localhost:9090/api/v1/library/books/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "title": "AWS in action",
  "description": "AWS Book",
  "price": 30.0
}'
```

* Update an existing book

```
curl --location --request PUT 'http://localhost:9090/api/v1/library/books/' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 6,
  "title": "AWS IN ACTION",
  "description": "AWS Book",
  "price": 35.0
}'
```

* Finally, delete a book    

```
curl --location --request DELETE 'http://localhost:9090/api/v1/library/books/6'
```