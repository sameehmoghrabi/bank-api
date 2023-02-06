# Bank Application For Existing Customer
___
### Spring Boot and VueJS Application

---
This project provides to create account for existing customers.

### Summary
The assessment consists of an API to be used for opening a new “current account” of already existing
customers.

#### Requirements

• The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user whose ID is
customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname, balance, and
transactions of the accounts.
___
The application has 2 apis
* AccountAPI
* CustomerAPI

```html
POST /v1/accounts/add - creates a new account for existing customer
GET /v1/accounts - retrieves all accounts
GET /v1/customers/{customerId} - retrieves a customer
GET /v1/customers - retrieves all customers
POST /v1/customers/add - creates a new cutomer
```

### Technologies Used

---
- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Restful API
- H2 In memory database  
- VueJS for frontend

### Prerequisites

---
- Maven

### Run & Build___
*$PORT: 8080*
```ssh
$ cd account/account-api
$ mvn clean install
$ java -jar target/bank-app-1.0.jar 
```