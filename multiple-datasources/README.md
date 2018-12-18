## Database setup
1. Create databases with the names datasources_db1 & datasources_db2
2. Create a user table in each db as shown below
```bash
CREATE TABLE `datasources_db1`.`user` 
( `id` BIGINT NOT NULL , `email` VARCHAR(50) NOT NULL , `name` VARCHAR(100) NOT NULL , `surname` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`)) 
ENGINE = InnoDB;
```

## How To Run
* gradle clean bootRun
* starts on port 8080
* Access localhost:8080/create/db1 in browser
* New User should be created in datasources_db1 and their ID returned
* Access to localhost:8080/create/db2
* New User should be created in datasources_db2 and their ID returned
* Done

## Related Blog Post:
[Working with multiple datasources and NamedParameterJdbcTemplate in Spring Boot 2.0.5](https://www.amuponda.com/2018/10/21/working-with-multiple-datasources-and-namedparameterjdbctemplate-in-spring-boot-2-0-5/)
