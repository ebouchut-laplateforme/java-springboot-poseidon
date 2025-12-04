# Poseidon Project

Poseidon is a trading Web application written in Java with the Spring Boot Framework.
It renders Web pages server side using Thymeleaf as a template engine.

## Project Status

See the [GitHub Project](https://github.com/orgs/ebouchut-laplateforme/projects/6) 
for up-to-date information.

## Tech Stack 

- [x] Java version 1.8
- [x] Spring Boot version 2.0.4
   - [x] Thymeleaf
- [ ] Bootstrap version .4.3.1

## Project Setup in IntelliJ IDEA

- [x] Create the project skeleton (already done)  
    2. Create project from Spring Boot Initializr (in IntelliJ): `File` > `New > project` > `Spring Initializr`
    1. Add `lib` repository into `pom.xml`
    1. Add folders
       - Source root: `src/main/java`
       - View: `src/main/resources`
       - Static: `src/main/resource/static`
- [ ] Create a database user named `poseidon`
- [ ] Create a database named `poseidon` as configured in `src/main/resources/application.yaml`
- [ ] Run the SQL script to create the tables `src/main/resources/db/schema.sql` in this database. 
- [ ] Run the SQL script to populate the tables of this database: `src/main/resources/db/data.sql` 

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