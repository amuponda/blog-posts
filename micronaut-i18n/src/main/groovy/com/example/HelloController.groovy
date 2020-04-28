package com.example

import io.micronaut.context.MessageSource
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {

    private final MessageSource messageSource

    HelloController(MessageSource messageSource) {
        this.messageSource = messageSource
    }

    @Get("/{lang}/{name}")
    String greeting(String lang, String name) {
        MessageSource.MessageContext messageContext =
                MessageSource.MessageContext.of(new Locale(lang), Collections.singletonMap("person.name", name))
        String template = messageSource.getMessage("greeting", messageContext).get()
        return messageSource.interpolate(template, messageContext)
    }
}
