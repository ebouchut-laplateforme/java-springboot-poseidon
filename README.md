# Poseidon Project

Poseidon is a trading Web application written in Java with the Spring Boot Framework.
It renders Web pages server side using Thymeleaf as a template engine.

## Pre-requisites

- [x] Java version 1.8
- [x] Spring Boot version 2.0.4
   - [x] Thymeleaf
- [ ] Bootstrap version .4.3.1

## Project Setup in IntelliJ IDEA

1. Create project from Initializr: `File` > `New > project` > `Spring Initializr`
1. Add `lib` repository into `pom.xml`
1. Add folders
   - Source root: `src/main/java`
   - View: `src/main/resources`
   - Static: `src/main/resource/static`
1. Create database with name `demo` as configuration in `application.properties`
1. Run the SQL script to create the tables `doc/data.sql` in the `demo` database. 

## Implement Features

1. Create **domain** classes in the `com.nnk.springboot.domain` package
2. Create **repository** classes in the `com.nnk.springboot.repositories` package
3. Create **controller** classes in the `com.nnk.springboot.controllers` package
4. Create **views** (Thymeleaf template files) under `src/main/resource/templates/` 

## Write Unit Test

Create Unit Tests in  `com.nnk.springboot` under the `test/java` folder

## Security

- Create `UserService`  in the `com.nnk.springboot.services` package to load users from the database   
- Add a _Configuration_ class in the `com.nnk.springboot.config` package