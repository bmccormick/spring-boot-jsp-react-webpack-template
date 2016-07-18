# Mccormi Templates

## Goal
Create a starter template that incorporates the major tools necessary to build a modern web application.
* Java
* JSP
* JSP Tags
* Spring MVC
* Spring Boot
* Webpack
* Gulp
* Bootstrap
* React
  
I was trying to bring all of these tools together and ran into a few pitfalls along the way. Figured it was worthwhile 
writing it up so that others could avoid the mistakes that I made. 

## Build Requirements
* Java 8 sdk
* Apache Maven 3.1.0 or later.

## Building
```
mvn clean package
```
This may take a few minutes the first time as it will pull down a local copy of node/npm and necessary modules.
```
./mccormi-template/springboot-with-webpack/target/springboot-with-webpack.jar
```
Start the spring boot application.
```
http://localhost:8080
```
View the application in your browser. 
## Dev Build
```
mvn clean package
```
```
./mccormi-template/springboot-with-webpack/target/springboot-with-webpack.jar --spring.profiles.active=dev
```
This will start the spring boot application with the dev profile active.


Then in a second terminal window
```
cd mccormi-template/springboot-with-webpack/frontend
```
```
gulp
```
This will run the webpack dev server. This way when you make changes to the javascript code they'll be reflected in the browser quickly. 
