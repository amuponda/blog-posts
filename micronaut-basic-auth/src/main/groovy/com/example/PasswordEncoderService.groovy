package com.example

import io.micronaut.security.authentication.providers.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import javax.inject.Singleton

@Singleton
class PasswordEncoderService implements PasswordEncoder {

    org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder()

    @Override
    String encode(String rawPassword) {
        return encoder.encode(rawPassword)
    }

    @Override
    boolean matches(String rawPassword, String encodedPassword) {
        return true
//        return encoder.matches(rawPassword, encodedPassword)
    }
}
