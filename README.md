## <p align="center">Spring Boot Application</p>

****

### Overview

A Spring Boot application that manages entities related to persons, identity proofs, and projects. It provides RESTful
endpoints for CRUD operations on these entities.

### Usage

To run this Spring Boot application locally, follow these steps:

1. Clone the
   repository&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `git clone https://github.com/PavanReddy0604/Spring-boot-Monolith.git`
2. Navigate to the project directory&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`cd <project-directory>`
3. Build the project&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  `./mvnw clean package`
4. Run the application&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; `java -jar target/<project-name>.jar`

### Idea based on which this project is developed

- IdProof and Person Entities have One To One mapping between them that means, We can't have multiple IdProofs for a
  single person and vice versa
- Person and Project Entities have One To Many Mapping between them that means, One person can make multiple projects.

### APIs

- [IdProof](#IdProof)
- [Project](#Project)

#### <ins>IdProof</ins>

- [Save IdProof](#Save-IdProof)
- [Get all IdProofs](#get-all-idproofs)
- [Get IdProof By ProofName](#get-idproof-by-poofname)
- [Update IdProof](#update-idproof)
- [Delete IdProof]()

#### <ins>Project</ins>

- [Save Project]()
- [Get all Projects]()
- [Get all Projects By Person]()
- [Update Project]()
- [Delete Project]()

##### Save IdProof

> Method :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; POST  
> EndPoint :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /idProof/  
> Content-Type: application/json

**Request Body**

```json
{
  "proofName": "Adhar card",
  "person": {
    "personName": "Pavan Kumar Reddy",
    "gender": "MALE",
    "mobileNumber": 10000000
  }
}
```

**Response**

```diff
Id of the saved IdProof
```

##### Get all IdProofs

> Method :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; GET  
> EndPoint :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /idProof/

**Request Body**

- No Request body is required

**Response Body**

```json
[
  {
    "proofId": "4e6d0a72-3e2c-4d8f-aa87-f70e6f61ea18",
    "proofName": "Adhar card",
    "person": {
      "personId": "a32667a3-9f64-48a5-962c-79de8ec0392c",
      "personName": "Pavan Kumar Reddy",
      "gender": "MALE",
      "mobileNumber": 10000000,
      "project": []
    }
  }
]
```

##### Get IdProof by PoofName

> Method :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; GET  
> EndPoint :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /idProof/proofName/{proofName}

**Request Body**

- No Request body is required

**Response Body**

```json
[
  {
    "proofId": "4e6d0a72-3e2c-4d8f-aa87-f70e6f61ea18",
    "proofName": "Adhar card",
    "person": {
      "personId": "a32667a3-9f64-48a5-962c-79de8ec0392c",
      "personName": "Pavan Kumar Reddy",
      "gender": "MALE",
      "mobileNumber": 10000000,
      "project": []
    }
  }
]
```

##### Update IdProof

> Method&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PUT  
> EndPoint&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
> /idProof/  
> Content-Type&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;application/json
**Request Body**

```json
  {
  "proofId": "f8088b94-a08c-4c53-b5e7-1663954794af",
  "proofName": "Adhar",
  "person": {
    "personId": "907ef321-1f56-48b3-856b-d4e8f5a5e806",
    "personName": "Pavan Kumar Reddy",
    "gender": "MALE",
    "mobileNumber": 9704002726232
  }
}
  ```

**Response Body**

``` diff
Id of the updated IdProof
```

##### Delete IdProof

> Method :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; DELETE  
> EndPoint :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /idProof/{proofId}

**Request Body**

- No Request body is required

**Response Body**

``` diff
Id of the deleted IdProof
```

### Tech stack and tools used

* Java
* Spring boot
* Postgres
* Rest API
* Maven





