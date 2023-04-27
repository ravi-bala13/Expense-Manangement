# Expense-Manangement
If you want clone this project Run the following command

```
git clone https://github.com/ravi-bala13/Expense-Manangement.git
```

## Creating and Starting a Java Spring Boot Project with MongoDB
This project provides a basic template for creating a Java Spring Boot application that uses MongoDB as the database. Follow the instructions below to create and start the project.

## Prerequisites
Before starting, make sure you have the following installed on your computer:

* Java Development Kit (JDK)
* MongoDB
* Maven
* Intellij idea(Editor as your wish)

## Creating the Project
* Open a terminal or command prompt and navigate to the directory where you want to create the project.

* Run the following command to create a new Spring Boot project using Maven:
```
mvn archetype:generate -DgroupId=com.example -DartifactId=demo -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

* Navigate into the newly created demo directory.

* Add the following dependencies to the pom.xml file:
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
</dependencies>
```
Run the following command to update the Maven dependencies:

```
mvn clean install
```
### you can create spring boot project directly here -> (https://start.spring.io/) instead of doing the above process

## Configuring MongoDB
* Start the MongoDB server by running the following command:

```
mongod
```

* In a new terminal or command prompt window, run the following command to start the MongoDB shell:

```
mongo
```

* In the MongoDB shell, create a new database by running the following command:

```
use mydb
```

* Create a new collection in the mydb database by running the following command:

```
db.createCollection("mycollection")
```

## Running the Project
* In the demo directory, create a new file called application.properties and add the following configuration:

```
spring.data.mongodb.uri=mongodb://localhost:27017/mydb
```

## Run the following command to start the Spring Boot application:

```
mvn spring-boot:run
```

Open a web browser and navigate to http://localhost:8080. You should see a message indicating that the application is running.

Conclusion
Congratulations, you have successfully created and started a Java Spring Boot project using MongoDB as the database. You can now modify the project to suit your needs and build your own application.
