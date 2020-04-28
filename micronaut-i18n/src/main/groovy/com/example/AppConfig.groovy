package com.example

import io.micronaut.context.MessageSource
import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import io.micronaut.context.i18n.ResourceBundleMessageSource

@Factory
class AppConfig {
    @Bean
    MessageSource messageSource() {
        new ResourceBundleMessageSource('Messages')
    }
}
