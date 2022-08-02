# Exercise krello web page

**This proyect contains a TO DO list proyect**

___
**useful information**

Database PORT = 8080

Database = mySQL

___
**Frontend info:**

folder = front-end

index (where boards are) = http://127.0.0.1:5500/source/index.html

Management of tasks and columns = http://127.0.0.1:5500/source/columns.html/{id}

javascript-html-css

fetch to get-handle data from server(krello)

___
**Backend info:**

folder = backend

spring_boot(maven)

**Database info:**

folder = resources

contains the database and useful functions to test the project.

___
## Structure krello ##
**Board**

```
"id": 5,
            "name": "prueba up",
            "createdAt": "2022-07-27T17:43:55Z",
            "updatedAt": "2022-07-31T09:48:07Z",
            "columnsForBoard": [
                {
                    "id": 13,
                    "createdAt": "2022-07-29T21:20:35Z",
                    "updatedAt": null
                },
                {
                    "id": 14,
                    "createdAt": "2022-07-29T21:20:35Z",
                    "updatedAt": null
                },
                {
                    "id": 15,
                    "createdAt": "2022-07-29T21:20:35Z",
                    "updatedAt": null
                }
```


**ColumnDTO**

```
{
            "id": 1,
            "name": "Por realizar",
            "tasks": [
                {
                    "id": 2,
                    "name": "Crear el backend del Reto de Programación Web"
                    }]
}
                
```



**task**

```
            "id": 1,
            "idColumn": 2,
            "idBoard": 1,
            "name": "Crear el frontend",
            "description": null,
            "delivery": null,
            "created": "2022-08-01T20:39:19Z",
            "updated": null,
            "logs": [
                {
                    "id": 1,
                    "taskId": 1,
                    "previousId": 1,
                    "currentId": 1,
                    "createdAt": "2022-07-29T18:56:25Z"
                }]

```


**Log**

```
{
        "id": 1,
        "taskId": 1,
        "previousId": 1,
        "currentId": 1,
        "createdAt": "2022-07-29T18:56:25Z"
    }
```

## Requests ##

**Board:**

1.Get boards(GET)= http://localhost:8080/api/v1/boards

2.Get board(GET)= http://localhost:8080/api/v1/board/{boardId}

3.Create board(POST)= http://localhost:8080/api/v1/board

4.Update board(PUT)= http://localhost:8080/api/v1/board/{boardId}

5.Delete board(DELETE)= http://localhost:8080/api/v1/board/{boardId}

**Column:**

1.Get boards(GET)= http://localhost:8080/api/v1/columns

2.Get DTO(GET)= http://localhost:8080/api/v1/column/dto/{boardId}

**Task:**

1.Get Task(GET)= http://localhost:8080/api/v1/task/{idTask}

2.Create task(POST)= http://localhost:8080/api/v1/task

3.Update task(PUT)= http://localhost:8080/api/v1/task/{idTask}

4.Delete task(DELETE)= http://localhost:8080/api/v1/task/{idTask}

**log:**

1.Get log(GET)= http://localhost:8080/api/v1/log/{idLog}

2.Create log(POST)= http://localhost:8080/api/v1/log