# Quarker

microservice-based discussion board using

* Quarkus
* Docker
* Caddy for development
* MariaDB

this project is just for researching / studying  and will never go live or productive - i think ;-)

## Run

```
docker-compose up
mvn -f ./comment/pom.xml quarkus:dev
mvn -f ./thread/pom.xml quarkus:dev
npm --prefix frontend run start
```

## Frontend

http://localhost:8080

## Endpoints

* `GET http://locahost:8080/api/comments?threadId=:threadId`
* `POST http://locahost:8080/api/comments`
* `GET http://locahost:8080/api/threads`
* `GET http://locahost:8080/api/threads/:id`
* `POST http://locahost:8080/api/threads`

