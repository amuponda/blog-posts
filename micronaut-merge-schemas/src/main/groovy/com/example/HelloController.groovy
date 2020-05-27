package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller
class HelloController {

    @Get("/")
    String greeting() {
        return "Hello"
    }
}
