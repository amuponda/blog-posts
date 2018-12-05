#Overview
Have a look at the `application.yml` to see how to configure a grails SBA client to use the SBA server with security disabled.

## Spring Boot Admin Server
```bash
cd server
gradle clean bootRun
# server should start at localhost:8989
```

## Spring Boot Admin Client
```bash
cd client
grails run-app
# client should start up at localhost:8080
```
### Related Blog Post:
[Adding Spring Boot Admin to a Grails 3 Application](https://www.amuponda.com/2018/11/29/adding-spring-bo…ails-application/)
