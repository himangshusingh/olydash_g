### To run the server and access the API

1. Clone the repository
2. Run the command `./gradlew bootRun` from the backend folder
3. Install the postman client
4. Import the collection and environment from the file `olympic.postman_collection.json`
5. Run the collection

### Dependencies

```
Java 17
Gradle 8.4
```


### API AUTHENTICATION

Now to test the api, API AUTHENTICATION IS NEEDED

To authenticate the API use the following header in Postman

```declarative
api.key= api-key-from-application.properties file
```

