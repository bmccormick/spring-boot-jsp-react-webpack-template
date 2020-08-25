# A template application integrating Spring Boot, JSP, React, and Webpack 

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
* Java 11 sdk
* Apache Maven 3.1.0 or later.

## Building
Build the application.
```
mvn clean package
```
This may take a few minutes the first time as it will pull down a local copy of node/npm and necessary modules.

Start the spring boot application.

```
./springboot-with-webpack/target/springboot-with-webpack.jar
```
View the application in your browser.
```
http://localhost:8080
```
## Dev Build
Build the application
```
mvn clean package
```
Start the spring boot application with the dev profile active.
```
./springboot-with-webpack/target/springboot-with-webpack.jar --spring.profiles.active=dev
```
Then in a second terminal window
```
cd springboot-with-webpack/src/main/javascript
```
Start the webpack dev server.
```
gulp
```
This will run the webpack dev server. This way when you make changes to the javascript code they'll be reflected in the browser quickly. 
