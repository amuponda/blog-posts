#Overview
This is a Micronaut 3.3.0 project to show how you can make use liquibase in a Micronaut to manage your database changelog. This example project uses Mariadb for the database.

## Micronaut 3.3.0 Documentation

- [User Guide](https://docs.micronaut.io/3.3.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.3.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.3.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## How to run
1. Create `mn-liqiubase` database for the project
2. run `./gradlew run` gradle command
3. The changelog should run and a `user` table should be created in the database

## Related Blog Post:
[Working with multiple datasources and NamedParameterJdbcTemplate in Spring Boot 2.0.5](https://www.amuponda.com/2018/10/21/working-with-multiple-datasources-and-namedparameterjdbctemplate-in-spring-boot-2-0-5/)

