# Paradigma Digital Technical Test

Technical test for the hiring process

## Design choices

This application was created using JDK 17 and Spring Boot 3 as a basis, with the Lombok library to reduce boilerplate code. 

An API YAML definition file was created to define the API structure and swagger-codegen was used to generate the starting code and its annotations, but was later refined to accomodate newer dependencies and `springfox-swagger-ui` was replaced with `springdoc` for easier integration with OpenAPI Specification 3.0

The API structure follows JSON REST patterns. Even though the defined use case is the retrieval of data, it's been decided to implement it using a POST endpoint instead of GET for a more convenient data input experience

The code follows the hexagonal architecture for complete decoupling of the domain, application and infrastructure layers.

The database for this application is an H2 in-memory database that loads the `import.sql` data every time the application starts.

## System Requirements

This application needs the following software installed to run correctly

* Java Runtime Environment 17 or later
* Apache Maven 3
* Docker

## Installation

To compile the Java application open a terminal and run the following command from the application's
root directory

```shell
mvn clean install
```

You can choose to run the application directly by running

```shell
java -jar technicaltest-1.0.0.jar
```

Alternatively, you can create a Docker image by executing the following command

```shell
docker build -t paradigmadigital/technicaltest .
```

And you can run it with the command

```shell
docker run -p 8080:8080 paradigmadigital/technicaltest
```

## Access endpoints

Assuming that the application is running locally and on the default 8080 port, you can access its different features with the following urls:

* http://localhost:8080/api to access the API directly
* http://localhost:8080/swagger-ui/index.html to access the API's Swagger UI
* http://localhost:8080/h2 to access the H2 Database console. Make sure the connection credentials are as follows:
  * **JDBC URL** field set to `jdbc:h2:mem:testdb`
  * **User name** field set to `admin`
  * **Password** field must be empty

A file named `TechnicalTest.postman_collection.json` is also included to load into Postman which includes a set of API requests that mirror the test cases defined for this test, as well as a separate request to more freely test the API endpoint 


Made with ♥️ by [Julio Martínez](https://www.linkedin.com/in/julio-mart%C3%ADnez-r%C3%B3denas-892bb5104/)
