# <h1 align="center">CRUD API with Spring Boot</h1>
## <h2 align="center">This project is a simple CRUD (Create, Read, Update, Delete) API implemented using Spring Boot, Hibernate, and H2 database. It provides endpoints to manage information about people including their first name, last name, and age.</h2>

## ***Note:*** This project is intended as a reference and learning resource. Feel free to explore the code and modify it according to your requirements.

## Features:
*  *Get all people:* Retrieve a list of all people stored in the database.
*  *Add a person*: Add a new person to the database with validation for required fields.
*  *Update a person:* Update information about an existing person in the database.
*  *Delete a person:* Remove a person from the database by their ID.

## Technologies Used:
* *Spring Boot:* For building the RESTful API and managing dependencies.
* *Hibernate:* For ORM (Object-Relational Mapping) to interact with the H2 database.
* *H2 Database:* An in-memory SQL database used for development and testing purposes.
* *Jakarta Validation API:* For input validation and error handling.

## Endpoints:
* *GET /:* Retrieve all people.
* *POST /add:* Add a new person. *(We have to use json object when sending data)*
```json
{
  "fname":"first_name",
  "lname":"last_name",
  "age":"age"
}
```

   
      
* *PUT /update/{id}:* Update information about an existing person *(We have to use json object when sending data)*.
##### id of the user that you need to change the data and the new data that you need to update
```json
{
  "fname":"first_name",
  "lname":"last_name",
  "age":"age"
}
```
* *DELETE /delete/{id}:* Delete a person by their ID.