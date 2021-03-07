# API Spec

## Authentication

All API must use this authentication

Request :
- Header :
    - X-Api-Key : "your secret api key"

## Create Student

Request :
- Method : POST
- Endpoint : `/api/student`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "idStudent" : "string, unique",
    "name" : "string",
    "address" : "string",
    "telephone" : "int"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "idSudent" : "string, unique",
         "name" : "string",
         "address" : "string",
         "telephone" : "integer",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Get Student

Request :
- Method : GET
- Endpoint : `/api/student/{idStudent}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "idSudent" : "string, unique",
         "name" : "string",
         "address" : "string",
         "telephone" : "integer",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## Update Student

Request :
- Method : PUT
- Endpoint : `/api/student/{idStudent}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :

```json 
{
    "name" : "string",
    "address" : "string",
    "telephone" : "integer"
}
```

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : {
         "id" : "string, unique",
         "name" : "string",
         "address" : "string",
         "telephone" : "integer",
         "createdAt" : "date",
         "updatedAt" : "date"
     }
}
```

## List Student

Request :
- Method : GET
- Endpoint : `/api/student`
- Header :
    - Accept: application/json
- Query Param :
    - size : number,
    - page : number

Response :

```json 
{
    "code" : "number",
    "status" : "string",
    "data" : [
        {
              "idStudent" : "string, unique",
              "name" : "string",
              "address" : "string",
              "telephone" : "integer",
              "createdAt" : "date",
              "updatedAt" : "date"
        },
        {
             "idStudent" : "string, unique",
             "name" : "string",
             "address" : "string",
             "telephone" : "integer",
             "createdAt" : "date",
             "updatedAt" : "date"
         }
    ]
}
```

## Delete Student

Request :
- Method : DELETE
- Endpoint : `/api/student/{idStudent}`
- Header :
    - Accept: application/json

Response :

```json 
{
    "code" : "number",
    "status" : "string"
}
```
