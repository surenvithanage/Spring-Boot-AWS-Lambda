# Spring-Boot-AWS-Lambda
Creating a Spring Boot project from scratch using Spring Initializer . Give Gradle as the build tool and select Java(version 8). Also add the Spring Web dependency to create web applications using Spring MVC.

Now, under the “server” package, we’ll add two packages to store model and controller classes.

Now if we go to the terminal and execute below command, the project will run on localhost with default port number 8080.

http://localhost:8080/ will give a Whitelabel error since we don’t have any endpoint implemented for path “/”. With http://localhost:8080/users endpoint, our users list will be returned as below.

[{"name":"John","age":20},{"name":"Mike","age":25}]

## Convert application to run as a Lambda function

This section includes how to convert our rest API application to a lambda function.

### Add dependency

aws-serverless-java-container-spring dependency to the build.gradle file. Then go to Gradle Tool window and sync the dependencies.

### Create AWS Lambda Handler

Lambda handler is a class which acts as the communication layer. This captures the requests and transfer it to the Spring Boot application. The SpringBootLambdaContainerHandler from the aws library is used to wrap our SpringBootServerlessApplication using getAwsProxyHandler method . The handleRequest method will be called each time when AWS Lambda function is invoked to pass user data and execute handle logic.

The getAwsProxyHandler method is expecting a WebApplicationInitializer class parameter . Since the SpringBootServletInitializer class implement the WebApplicationInitializer interface, we can update the SpringBootServerlessApplication class to extend the SpringBootServletInitializer on startup to configure the things.
