package com.amuponda.springbootdevtools

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/")
    String index() {
        return "Greetings from Spring Boot!"
    }
}
