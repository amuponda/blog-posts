package com.amuponda.multipledatasources

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.stereotype.Repository

@Slf4j
@Repository
class UserDao {

@Autowired
@Qualifier("namedParameterJdbcTemplateOne")
NamedParameterJdbcTemplate jdbcOne

@Autowired
@Qualifier("namedParameterJdbcTemplateTwo")
NamedParameterJdbcTemplate jdbcTwo

    Long insertIntoDbOne() {
        KeyHolder keyHolder = new GeneratedKeyHolder()
        String sql = "INSERT INTO users (name, surname, email) VALUES ('dbOne', 'User', 'dboneuser@user.com')"
        jdbcOne.update(sql, new MapSqlParameterSource(), keyHolder)
        return keyHolder.getKey()
    }

    Long insertIntoDbTwo() {
        KeyHolder keyHolder = new GeneratedKeyHolder()
        String sql = "INSERT INTO users (name, surname, email) VALUES ('dbTwo', 'User', 'dbtwouser@user.com')"
        jdbcTwo.update(sql, new MapSqlParameterSource(), keyHolder)
        return keyHolder.getKey()
    }
}
