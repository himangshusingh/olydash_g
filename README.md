
### GRADLE COMMAND
  
- For POWERSHELL : `./gradlew`
- For CMD : `gradle`

This file follows the Powershell approach, change the `./gradlew` with `gradle` depending upon your use case

-------------------------------

### To run the server and access the API

1. Clone the repository

2. Run the command `./gradlew bootRun` from the backend folder

3. Install the postman client

4. Import the collection and environment from the file `olympic.postman_collection.json`

5. Run the collection
------------------------
  
### If any changes made to the DB schema, then clean the db file and build again

  
1. Clean the db build file

```
./gradlew clean
```

2. Build the db file again

```
./gradlew build
```
  
3. Run the server again

```
./gradlew bootrun
```
--------------------------

### Dependencies

##### 1. Java 17
##### 2. Gradle 8.2.1
------------------------

### API AUTHENTICATION

  

Now to test the api, API AUTHENTICATION IS NEEDED


To authenticate the API use the following header in Postman

| KEY     | VALUE                                    |
| ------- | ---------------------------------------- |
| API-KEY | api-key-from-application.properties file |

There is no need for description as of now