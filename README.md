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
* mvn clean package
  * This may take a few minutes the first time as it will pull down a local copy of node/npm and necessary modules.
* ./mccormi-template/springboot-with-webpack/target/springboot-with-webpack.jar
* http://localhost:8080

## Dev Build
* mvn clean package
* ./mccormi-template/springboot-with-webpack/target/springboot-with-webpack.jar --spring.profiles.active=dev
* in a second terminal window
  * cd mccormi-template/springboot-with-webpack/frontend
  * gulp

You can run the springboot application in dev mode which requires the webpack dev server to be run as well. This way when you 
make changes to the javascript code they'll be reflected in the browser quickly. 
