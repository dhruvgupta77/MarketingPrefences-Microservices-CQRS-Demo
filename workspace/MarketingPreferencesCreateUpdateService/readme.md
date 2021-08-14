#Microservices with Spring Boot, H2 In Memory DB

This microservice is a demonstration of create update marketing preferences of a customer. Initially, I planned to built CQRS microservice application consisting of two collaborating microservices one for create update and other for read which combines together to produce one logical application. However, due to shortage of time the synchronization between read and write operations cannot be done. Package on Docker containers again cannot be completed due to shortage of time.

#Running the Demo

To run the code, you'll need to have the following software installed on your machine. 

 - Java SDK 8


###Step 2: Start the Microservices

gradle build the project
Start the application as Spring boot application
Import the collection CustomerPreferences.postman_collection.json in postman
Run again different inputs