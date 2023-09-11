# Payment Service Demo

This is a basic implementation REST API for a backend service based on Spring Boot 2 and Spring Data JPA.

The project uses a relational database and migrations tools in order to initialize the data. 

## How to run

Go to deployments folder and run the provided docker-compose file.
```
cd deployments
docker-compose up -d
```

Once the service is healthy you can start testing the app, you can use the OpenApi documentation.

http://localhost:8080/api-doc.html

## Development mode

This project uses an in-memory database for development purposes, in order to run the application you need to set DEV profile.
```
export SPRING_PROFILES_ACTIVE=dev
```
Then start the application with `bootRun`
```
./gradlew bootRun
```

### Run Test
```
$/gradlew test
```

### Build docker image

This project uses cloud native images, in order to build the docker image you need to run.
```
$ ./gradlew bootBuildImage -is
```

## TODOs
- Improve integration test.
- Improve business validations.
- Handle i18n messages.

## Licence
MIT
