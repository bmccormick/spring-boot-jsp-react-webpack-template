# Springboot-With-Webpack Module

This is the actual template module that will create an executable spring boot application with full support for 
javascript development and JSPs. 

## Java 
* All code for the application is bundled in an executable jar file in the target directory. 
* Since this is a Spring Boot Application, you can just add new controllers into the com.mccormi.template.controller package and they'll be picked up. 
* If you want to run this as a service on linux, you can symlink to the jar file from /etc/init.d/appName on a linux box and then start the application by calling "service appName start".
* JSP files are in src/main/resources/META-INF/resources/WEB-INF/jsp.
* tag files are in src/main/resources/META-INF/resources/WEB-INF/tags.
* Static assets are in src/main/resources/static

## Javascript 
* located in frontend/javascript
* you can create additional entry points in frontend/webpack.config.js which will be compiled and placed in src/main/resources/static/dist.
* The Javascript build process is controlled with gulp that calls webpack.
* The gulp build is hooked into the maven lifecycle as well so that calling 'mvn clean package' will also build css and javascript.

## CSS 
* located in either frontend/css or src/main/resources/static/css.
* code located in frontend/css will be processed by gulp and placed in src/main/resources/static/dist for serving.
