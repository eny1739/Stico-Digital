# **STICO DIGITAL** - BackEnd

## Description

Stico Digital is a REST API for manage products data (books), wallet, user account, and transactions.  The users can register an user account using username and password, after registering an account user can login using username and password that has been registered. 

Before user access this API, user must first log on. Using this REST API to make it easier for users to top up and pay the bill when user buy books. This application using jwt security and has several main features, which are:

1. Register for new user
2. Login using username and password
3. Update user account profile
4. Each user can have two or more e-wallets account
5. User can top-up and pay the bills when user buy books using e-wallet
6. The history of transactions is recorded in the report

## Getting Started

### Dependencies

This REST API created using :

* Linux Ubuntu 20.04 OS
* Intellij IDEA
* SpringBoot Framework with dependencies : spring-boot-starter-web, postgresql, spring-boot-starter-test, spring-boot-starter-security, jjwt-api, jjwt-impl, spring-data-jpa

### Prerequisite

Before user can access this REST API, user must prepare :

* Environment variable 

  * SECRET, for saving secret word when create jwt token
  * DB_USERNAME, for saving data credential (username) when access database
  * DB_PASSWORD, for saving data credential (password) when access database

* Open JDK 1.8 [Open JDK 1.8]: https://openjdk.java.net/install

### Instalation

Use the package manager 

[maven]: https://maven.apache.org/

```
mvn clean install
```

running application

```
java -jar target/InterviewProject-0.0.1-SNAPSHOT.jar
```

### REST API Documentation

For access this REST API user can access [swagger UI]: http://localhost:8086/swagger-ui.html#/	"REST API Documentation for Stico Digital" after user running this application

### Support

Further information email me : [enysulistyowati336@gmail.com]

or visit my github [github.com/eny1739]: https://github.com/eny1739

