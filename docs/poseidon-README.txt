# Poseidon Project

Poseidon is a trading Web application written in Java with the Spring Boot Framework.
It renders Web pages server side using Thymeleaf as a template engine.

## Pre-requisites

- [x] Java version 1.8
- [x] Spring Boot version 2.0.4
    - [x] Thymeleaf
- [ ] Bootstrap v.4.3.1

## Project Setup in IntelliJ IDEA

1. Create project from Initializr: File > New > project > Spring Initializr
1. Add lib repository into pom.xml
1. Add folders
    - Source root: src/main/java
    - View: src/main/resources
    - Static: src/main/resource/static
1. Create database with name "demo" as configuration in application.properties
1. Run sql script to create table doc/data.sql

## Implement Features

1. Create mapping domain class and place in package com.nnk.springboot.domain
2. Create repository class and place in package com.nnk.springboot.repositories
3. Create controller class and place in package com.nnk.springboot.controllers
4. Create view files and place in src/main/resource/templates

## Write Unit Test

1. Create unit test and place in package com.nnk.springboot in folder test > java

## Security
1. Create user service to load user from  database and place in package com.nnk.springboot.services
2. Add configuration class and place in package com.nnk.springboot.config