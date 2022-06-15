RecipeBook
==========

RecipeBook is a **Spring Boot application** which allows users to manage favourite recipes.


Building and Running
====================

```
Prerequisites:
docker (https://docs.docker.com/engine/install/)
docker-compose (https://docs.docker.com/compose/install/)

```

RecipeBook is Gradle (Gradle Wrapper) based project.
To **build** "application image" following command can be executed:

```
./gradlew bootBuildImage
```

Above command will create `docker.io/recipebook/app:latest` image, respecting directions contained in `Dockerfile`.
After the image is successfully built it is possible to **run** it in Docker container with "docker-compose".

```
docker-compose up
docker-compose down
```

Above commands are used to **start** the application or to **stop** it. 
Please note that `docker-compose` will start three services:

(1) `app` service running application image.

(2) `dbadmin` service running PgAdmin.

(3) `db` service running PostgreSQL.


(1) app service
---------------

- RecipeBook application is compiled with Java OpenJDK 11 version.
- After application is started it will preload database data using `Flyway` database management tool.
- Application is listening on default (8080) port ([http://localhost:8080/](http://localhost:8080/)).

(2) dbadmin service
-------------------

- PgAdmin service is listening on 8082 port ([http://localhost:8082/](http://localhost:8082/)).
- PgAdmin login credentials - Username: user@mail.com, Password: secret
- Please allow service to fully load (about 10sec) before trying to login.
- To connect PgAdmin with application database some steps need to be taken:

```
1. Login to PgAdmin with (user@mail.com, secret) credentials.
2. Click on "Add New Server".
3. PopUp Window - General tab - Name field: Enter some name, e.g. "db"
4. PopUp Window - Connection tab - Host name/address: db
5. PopUp Window - Connection tab - Port: 5432
6. PopUp Window - Connection tab - Maintenance database: postgres
7. PopUp Window - Connection tab - Username: postgres
8. PopUp Window - Connection tab - Password: postgres
9. PopUp Window: Click on "Save".
```

After that PgAdmin "Browser" part (left part of window) will show application database:

```
Servers/db/Databases/postgres[/Schemas/public/Tables]
```

(3) db service
--------------

- Application is using PostgreSQL to persist its data.
- Database is listening on 5432 port.
- Telnet can be used to test database connection, e.g. `telnet localhost 5432`


Other useful commands
---------------------

- To cleanup mess during development and testing process following Docker commands can be used:

```
(1) docker images -a
(2) docker rmi recipebook/app:latest
(3) docker image prune
```
(1) List all docker images.

(2) Delete application image.

(3) Delete all unused docker images.


- To run Unit tests `./gradlew test` can be executed.


Documentation
=============

- API documentation is provided via OpenAPI and (while application is running) it can be found at [http://localhost:8080/api-docs.html](http://localhost:8080/api-docs.html)
- JavaDoc documentation can be generated via Gradle plugin with following command:

```
./gradlew javadoc
```
After documentation is generated start `index.html` from `build/docs/javadoc/` folder.


ToDo
====

- Introduce custom application logging

- Improve input data validation

- Improve API documentation (including correct examples)

- Improve JavaDoc documentation

- Better Recipe creation time handling (Timestamp vs. LocalDateTime)

- Better Ingredients handling

- Increase number of tests (Controller, Service, Repository layer)

- Flyway should be responsible for database schema creation
