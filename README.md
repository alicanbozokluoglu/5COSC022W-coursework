#### MLOps Pipeline Management API




#### Student Information

- Student Name: Alican Bozokluoglu
- Student ID: W2167917
- University: University of Westminster
- Module Code: 5COSC022W
- Module Title: Client-Server Architectures
- Coursework: MLOps Pipeline Management API
- Programming Language:** Java
- Framework: Jersey (JAX-RS)
- Build Tool: Maven
- Server: Grizzly HTTP Server




#### Project Overview

The purpose of this coursework is to design and implement a RESTful web service using Java and the JAX-RS framework. The system simulates a cloud-native Machine Learning Operations (MLOps) platform that allows users to manage machine learning workspaces, deployed models, and historical evaluation metrics.

The API follows REST architectural principles and provides a structured interface for interacting with machine learning resources. The implementation focuses on resource-based design, nested resources, exception handling, request/response logging, and the correct use of HTTP methods and status codes.

The application is completely in-memory and stores all data using Java collections such as `ArrayList` and `HashMap`, as required by the coursework specification. No external database technology has been used.




#### System Architecture

The application follows a resource-oriented REST architecture.

The project consists of the following major components:

- REST Resources
- POJO Models
- In-Memory DataStore
- Exception Mappers
- Logging Filter
- Embedded Grizzly HTTP Server

The API entry point is:

```

http://localhost:9090/api/v1/

```

The application is bootstrapped using Jersey together with an embedded Grizzly HTTP Server.




#### Project Structure

```
mlops-api
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── mlops/
│   │   │           └── api/
│   │   │               ├── ApiApplication.java
│   │   │               ├── ApiConfig.java
│   │   │               ├── DataStore.java
│   │   │               ├── ErrorResponse.java
│   │   │               ├── EvaluationMetric.java
│   │   │               ├── EvaluationMetricResource.java
│   │   │               ├── GlobalExceptionMapper.java
│   │   │               ├── HelloResource.java
│   │   │               ├── LinkedWorkspaceNotFoundException.java
│   │   │               ├── LinkedWorkspaceNotFoundExceptionMapper.java
│   │   │               ├── LoggingFilter.java
│   │   │               ├── MLModel.java
│   │   │               ├── MLWorkspace.java
│   │   │               ├── ModelDeprecatedException.java
│   │   │               ├── ModelDeprecatedExceptionMapper.java
│   │   │               ├── ModelResource.java
│   │   │               ├── WorkspaceNotEmptyException.java
│   │   │               ├── WorkspaceNotEmptyExceptionMapper.java
│   │   │               └── WorkspaceResource.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── target/
│
├── pom.xml
│
└── README.md
```




#### Main Features

The API provides complete management functionality for machine learning workspaces and deployed models.

Implemented functionality includes:

- API Discovery endpoint
- Workspace CRUD operations
- Model CRUD operations
- Nested Metric Resource
- Automatic UUID generation
- Automatic timestamp generation
- Status filtering
- Business rule validation
- Custom Exception Mapping
- Global Exception Handling
- Request & Response Logging




#### Implemented REST Resources




#### Discovery Resource

```

GET /api/v1/

```

Returns general API information including:

- API Name
- Version
- Administrator Contact
- Available Resources




#### Workspace Resource

```

GET /api/v1/workspaces

```

Returns all workspaces.

```

POST /api/v1/workspaces

```

Creates a new workspace.

```

GET /api/v1/workspaces/{workspaceId}

```

Returns a single workspace.

```

DELETE /api/v1/workspaces/{workspaceId}

```

Deletes a workspace only if no models are linked to it.




#### Model Resource

```

GET /api/v1/models

```

Returns all registered models.

```

GET /api/v1/models?status=DEPLOYED

```

Filters models using a query parameter.

```

POST /api/v1/models

```

Registers a new model.

```

GET /api/v1/models/{modelId}

```

Returns a single model.

```

DELETE /api/v1/models/{modelId}

```

Deletes the selected model.




##### Evaluation Metric Resource

```

GET /api/v1/models/{modelId}/metrics

```

Returns all evaluation metrics for a model.

```

POST /api/v1/models/{modelId}/metrics

```

Adds a new evaluation metric.

The API automatically:

- Generates a Metric ID if not supplied.
- Generates the current timestamp.
- Updates the latest model accuracy.
- Rejects metrics for deprecated models.




#### REST Principles Used

The implementation follows the major REST architectural principles.

- Client-Server Architecture
- Stateless Communication
- Resource-Based URLs
- Standard HTTP Methods
- JSON Representation
- Proper HTTP Status Codes
- Nested Resources
- Separation of Concerns

All endpoints are designed around resources rather than actions.




#### Build Instructions




#### Requirements

The following software must be installed before running the application:

- Java JDK 17 or later
- Apache Maven
- Git




#### Clone Repository

```bash
git clone https://github.com/alicanbozokluoglu/5COSC022W-coursework.git
```

Move into the project directory.

```bash
cd 5COSC022W-coursework
```




#### Compile the Project

Compile the source code using Maven.

```bash
mvn clean compile
```

If the compilation is successful, Maven will build the project without errors.




#### Run the Application

Start the embedded Grizzly HTTP Server.

```bash
mvn exec:java -Dexec.mainClass="com.mlops.api.ApiApplication"
```

The server starts on:

```
http://localhost:9090/api/v1/
```

When the server starts successfully, the console displays:

```
MLOps API is running at:
http://localhost:9090/api/v1/
Press Ctrl+C to stop the server.
```




#### API Testing

The API was manually tested using cURL.

Every endpoint required by the coursework specification was successfully verified.

The following functionality was tested:

- Discovery endpoint
- Workspace CRUD operations
- Model CRUD operations
- Model filtering
- Nested Metric Resource
- Automatic UUID generation
- Automatic Timestamp generation
- Automatic latestAccuracy update
- Workspace deletion protection
- Linked Workspace validation
- Deprecated Model validation
- Global Exception handling
- Logging Filter




#### Example cURL Requests



#### 1. Discovery Endpoint

```bash
curl -i http://localhost:9090/api/v1/
```




#### 2. Retrieve all Workspaces

```bash
curl -i http://localhost:9090/api/v1/workspaces
```




#### 3. Retrieve a Workspace

```bash
curl -i http://localhost:9090/api/v1/workspaces/ws-001
```




#### 4. Create a Workspace

```bash
curl -i -X POST http://localhost:9090/api/v1/workspaces \
-H "Content-Type: application/json" \
-d '{
"workspaceidentifier":"ws-003",
"workspaceteamname":"Robotics Team",
"storagequotagigabyte":250
}'
```




#### 5. Retrieve all Models

```bash
curl -i http://localhost:9090/api/v1/models
```




#### 6. Filter Models

```bash
curl -i "http://localhost:9090/api/v1/models?status=DEPLOYED"
```




#### 7. Create Model

```bash
curl -i -X POST http://localhost:9090/api/v1/models \
-H "Content-Type: application/json" \
-d '{
"frameworkname":"Scikit-Learn",
"currentmodelstatus":"TRAINING",
"latestaccuracyscore":0.75,
"linkedworkspaceidentifier":"ws-001"
}'
```




#### 8. Add Evaluation Metric

```bash
curl -i -X POST http://localhost:9090/api/v1/models/model-001/metrics \
-H "Content-Type: application/json" \
-d '{
"modelaccuracyscore":0.95
}'
```




#### 9. Retrieve Metrics

```bash
curl -i http://localhost:9090/api/v1/models/model-001/metrics
```




#### 10. Test Global Exception

```bash
curl -i http://localhost:9090/api/v1/crash
```




#### HTTP Status Codes

| Status | Description |
|---------|-------------|
|200 OK|Successful request|
|201 Created|New resource created successfully|
|403 Forbidden|Deprecated models cannot receive metrics|
|404 Not Found|Requested resource does not exist|
|409 Conflict|Workspace still contains models|
|422 Unprocessable Entity|Linked Workspace does not exist|
|500 Internal Server Error|Unexpected server exception|




#### Design Decisions

Several software engineering decisions were made during the implementation.



#### Resource-Oriented Design

Every endpoint represents a REST resource rather than an action.

Examples include:

```
/workspaces
/models
/models/{modelId}
/models/{modelId}/metrics
```

This follows REST best practices.




##### In-Memory Storage

The coursework specification explicitly states that database systems must not be used.

Therefore, the application stores data inside Java collections.

The following data structures are used:

- ArrayList
- HashMap

This keeps the application lightweight and satisfies the coursework requirements.




##### Nested Resources

Evaluation metrics belong to a specific Machine Learning model.

For this reason, metrics are implemented as nested resources:

```
/models/{modelId}/metrics
```

using the JAX-RS Sub-Resource Locator pattern.




##### Error Handling

Business logic exceptions are separated from unexpected runtime errors.

Specific ExceptionMappers return meaningful HTTP responses while the GlobalExceptionMapper prevents Java stack traces from being exposed to clients.




##### Logging

Every HTTP request and response is logged using:

- ContainerRequestFilter
- ContainerResponseFilter

The logs include:

- HTTP Method
- Request URI
- Response Status



#### Coursework Questions and Answers




#### Part 1 – Service Architecture & Setup




#### Question 1

##### When returning a Java object from a REST endpoint, it is automatically converted into JSON. Explain the role of a MessageBodyWriter or a JSON provider such as Jackson.

**Answer**

When a Java object is returned from a JAX-RS resource method, it cannot be sent directly over HTTP because HTTP transmits text or binary data. A MessageBodyWriter is responsible for converting Java objects into a format that can be transmitted to the client. In this project, a JSON provider such as Jackson automatically serialises Java POJOs into JSON. This process allows clients to receive structured JSON responses without requiring manual conversion inside the resource classes.




##### Question 2

##### Explain the meaning of Statelessness in REST and why it improves scalability.

**Answer**

Statelessness means that every HTTP request contains all the information required for the server to process it. The server does not store any client session information between requests. Because each request is independent, any server instance can process it, making load balancing much easier. This significantly improves scalability, availability, and fault tolerance in cloud-based applications because requests can be distributed across multiple servers without maintaining session state.




#### Part 2 – Workspace Management




#### Question 3

#### How could Cache-Control improve the performance of the GET workspaces endpoint?

**Answer**

Cache-Control allows clients and intermediate proxies to temporarily store responses from the server. If the workspace data has not changed, the client can reuse the cached response instead of sending another request. This reduces network traffic, decreases server workload, and improves response times for users. Proper caching also increases the overall scalability of REST APIs.




##### Question 4

##### Which HTTP method should a client use to check whether a workspace exists without downloading the entire response body?

**Answer**

The HEAD method should be used. HEAD works similarly to GET but returns only the HTTP headers without the response body. This allows a client to verify whether a resource exists while reducing bandwidth usage. If the workspace exists, the server returns a successful status code such as 200 OK. Otherwise, it returns an appropriate error such as 404 Not Found.




#### Part 3 – Model Operations




##### Question 5

##### Why should the server generate resource IDs instead of allowing the client to provide them?

**Answer**

Allowing the server to generate unique identifiers improves both security and data integrity. Clients may accidentally or intentionally provide duplicate or invalid identifiers, which could overwrite existing resources or create inconsistent data. Server-generated UUIDs guarantee uniqueness, prevent conflicts, and ensure that identifiers remain under the control of the application rather than external users.




##### Question 6

##### Why is URL encoding necessary when query parameters contain spaces or special characters?

**Answer**

URLs only allow a limited set of characters. Spaces and many special characters must therefore be encoded before being transmitted over HTTP. For example, a space is encoded as `%20`. URL encoding ensures that the server correctly interprets the request and prevents malformed URLs or unexpected behaviour caused by reserved characters.




#### Part 4 – Deep Nesting with Sub-Resources




##### Question 7

##### What is the advantage of placing @Produces at the class level instead of the method level?

**Answer**

Applying `@Produces(MediaType.APPLICATION_JSON)` at the class level reduces code duplication because all resource methods automatically produce JSON responses. If a specific method needs to return a different media type, it can override the class-level annotation by defining its own `@Produces` annotation. This improves code readability and maintainability.




#### Part 5 – Exception Handling and Logging




##### Question 8

##### Why should a validation error caused by a non-existent workspace return a 4xx status code instead of a 5xx status code?

**Answer**

A 4xx status code indicates that the client submitted an invalid request. In this case, the client referenced a workspace that does not exist, so the error originates from the request itself rather than from the server. A 5xx status code would incorrectly suggest that the server failed internally, even though the application is functioning correctly.




##### Question 9

##### If both a specific ExceptionMapper and a Global ExceptionMapper exist, which one is used?

**Answer**

JAX-RS always selects the most specific ExceptionMapper that matches the thrown exception. For example, if a `LinkedWorkspaceNotFoundException` is thrown, the corresponding `LinkedWorkspaceNotFoundExceptionMapper` is executed. The global `ExceptionMapper<Throwable>` is only used when no more specific mapper exists.




##### Question 10

##### Which useful pieces of information can be obtained from ContainerRequestContext and ContainerResponseContext?

**Answer**

These classes provide valuable debugging information. Examples include:

- HTTP request method (GET, POST, DELETE, etc.)
- Request URI
- HTTP headers
- Query parameters
- Response status code
- Response headers

This information is useful for debugging, monitoring API usage, troubleshooting errors, and auditing requests.




#### Testing Results

The application was manually tested using cURL after deployment.

The following functionality was successfully verified:

| Feature | Status |
|---------|--------|
| API Discovery Endpoint | Passed |
| Retrieve All Workspaces | Passed |
| Retrieve Workspace by ID | Passed |
| Create Workspace | Passed |
| Delete Empty Workspace | Passed |
| Prevent Deleting Non-Empty Workspace | Passed |
| Retrieve All Models | Passed |
| Retrieve Model by ID | Passed |
| Filter Models by Status | Passed |
| Create New Model | Passed |
| Validate Linked Workspace | Passed |
| Retrieve Model Metrics | Passed |
| Create Evaluation Metric | Passed |
| Automatic Metric ID Generation | Passed |
| Automatic Timestamp Generation | Passed |
| Automatic latestAccuracy Update | Passed |
| Reject Deprecated Model Metrics | Passed |
| Global Exception Handling | Passed |
| Request Logging | Passed |
| Response Logging | Passed |




#### Exception Handling

The API implements multiple Exception Mappers to ensure meaningful HTTP responses.

| Exception | HTTP Status |
|-----------|-------------|
| WorkspaceNotEmptyException | 409 Conflict |
| LinkedWorkspaceNotFoundException | 422 Unprocessable Entity |
| ModelDeprecatedException | 403 Forbidden |
| GlobalExceptionMapper | 500 Internal Server Error |

Every exception returns a JSON response instead of exposing Java stack traces.

Example:

```json
{
    "errormessagetext":"Workspace cannot be deleted because it still contains models."
}
```




#### Logging

The application implements both:

- ContainerRequestFilter
- ContainerResponseFilter

Every HTTP request records:

- Request Method
- Request URI

Every HTTP response records:

- HTTP Status Code

Example output:

```
Incoming request: GET http://localhost:9090/api/v1/models

Outgoing response: GET http://localhost:9090/api/v1/models -> Status: 200
```

This makes debugging significantly easier during development.




#### Technologies Used

The project was developed using the following technologies:

- Java
- JAX-RS (Jersey)
- Apache Maven
- Grizzly HTTP Server
- JSON
- ArrayList
- HashMap
- UUID
- Java Util Logging




#### Project Summary

This project demonstrates the implementation of a complete RESTful API using Java and Jersey (JAX-RS).

The API successfully implements:

- RESTful resource design
- CRUD operations
- Nested resources
- Query parameters
- Exception mapping
- Global exception handling
- Request and response logging
- Business rule validation
- Automatic JSON serialization
- Appropriate HTTP status codes

The implementation follows REST architectural principles and satisfies the functional requirements specified in the coursework brief.




#### GitHub Repository

Repository URL:

```
https://github.com/alicanbozokluoglu/5COSC022W-coursework
```




#### Author

**Alican Bozokluoglu**

Student ID: **W2167917**

University of Westminster

Module: **5COSC022W – Client-Server Architectures**
