package com.amuponda.multipledatasources


import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

import javax.sql.DataSource

@Configuration
class DatabaseConfig {

@Bean
@Primary
@ConfigurationProperties(prefix = "db1.datasource")
DataSource dataSourceOne() {
    return DataSourceBuilder.create().build()
}

@Bean
@ConfigurationProperties(prefix = "db2.datasource")
DataSource dataSourceTwo() {
    return DataSourceBuilder.create().build()
}

@Bean
NamedParameterJdbcTemplate namedParameterJdbcTemplateOne() {
    return new NamedParameterJdbcTemplate(dataSourceOne())
}

@Bean
NamedParameterJdbcTemplate namedParameterJdbcTemplateTwo() {
    return new NamedParameterJdbcTemplate(dataSourceTwo())
}

}
