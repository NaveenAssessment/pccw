# pccw
PCCW Assignment

Git Hub Repository
https://github.com/NaveenAssessment/pccw

SOFTWARE USED
1. Java 8 
2. Spring Boot 1.5.10.RELEASE 
3. Maven 3.3.9 
4. MySQL 5.7.21 
5. Spring fox  2.6.1 for Swagger Open API
6. H2 database for Unit Testing
6. IDE - Spring Tool Suit


STEPS TO RUN THE APPLICATION AS JAVA APPLICATION AND INVOKE REST API

Note:
- This application is packaged as a jar, which has Tomcat 8, embedded in
Spring Boot Application.
- Make sure you are using JDK 1.8 and Maven 3.x
- Application runs on default tomcat port 8080. (Override the port no if port
used for different service --server.port=9090)

DESIGN AND SOLUTION APPROACH
Spring Boot Starter Class
- UserApiApplication.java Spring Boot framework is used to develop the service

Rest Controller
- UserApiController.java User Management API service is exposed as a rest service

Service Class
- UserServiceImpl.java Provides business logic user management functionality

Config Class
- BeanConfig.java Spring Bean configuration class for SessionFactory and Model Mapper

Util Class
- ObjectMapperUtil.java Util class for model to entity and entity to model mapper

DAO Class
UserDaoImpl.java DAO class for CRUD operations


MYSQL DATABASE SETUP

CREATE DATABASE TESTDB;

CREATE TABLE IF NOT EXISTS USERS (
ID INT (11) NOT NULL,
USER_NAME VARCHAR(40),
NAME VARCHAR(40),
PASSWORD VARCHAR(40),
EMAIL VARCHAR (40),
PRIMARY KEY (ID));
