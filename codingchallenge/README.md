## Environment
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.3.4.RELEASE

## Data
https://swapi.dev/api/

## Requirements
In this project, the APIs are developed as per the requirement  in the assessment. 

 Coding Challenge

Your challenge, should you choose to accept it, is to build a server that queries the Star Wars API for information on how to beat the Galactic Empire.

 Requirements

1. Build a REST API to connect to the Star Wars API {https://swapi.dev/documentation#intro}

2. Include a readme on how to interact with the API

3. Include tests

 Endpoints to build

1. Return a list of the Starships related to Luke Skywalker

2. Return the classification of all species in the 1st episode

3. Return the total population of all planets in the Galaxy

 Submission

Upload your application to a public repository and share the link with us
Following REST Endpoints have been implemented.

##  APIs 


`GET` request to `/api/luke-starships`:
* returns the starships of luke and status code 200


 `GET` request to `/api/ep_1_species`:
* returns all species of Episode 1 with status code 200

`GET` request to `/api/population-of-planets`:
* returns the total population of planets and status code 200
 
There are 3 tests written to validate all the endpoints

## Commands
- run: 
```bash
mvn clean spring-boot:run
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```