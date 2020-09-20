
# Task API

## features

1. Spring boot 2.3.3.RELEAS
1. Spring JPA
1. Gradle

## Database

__TASKS__

|NAME|TYPE        |
|:---|:-----------|
|ID  |BIGINT      |
|NAME|VARCHAR(255)|


## API
### Tasks

GET http://localhost:8080/tasks/

GET http://localhost:8080/task/{id}

POST http://localhost:8080/task/

DELETE http://localhost:8080/task/2

PATCH http://localhost:8080/task/1
