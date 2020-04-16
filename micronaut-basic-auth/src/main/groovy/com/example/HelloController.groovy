package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Controller("/hello")
@Secured(SecurityRule.IS_AUTHENTICATED)
class HelloController {

    @Get("/{name}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    String greeting(String name) {
        return "Hello ${name.capitalize()}"
    }

    @Get("/secured/{name}")
    String securedGreeting(String name) {
        return "Hello ${name.capitalize()}"
    }
}