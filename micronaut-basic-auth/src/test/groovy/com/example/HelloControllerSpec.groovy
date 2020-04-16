package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.security.authentication.providers.PasswordEncoder
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.test.annotation.MockBean
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Shared

import javax.inject.Inject

@MicronautTest
class HelloControllerSpec extends Specification {

    @Shared @Inject
    EmbeddedServer embeddedServer

    @Shared @AutoCleanup @Inject @Client("/hello")
    RxHttpClient client

    void "test unsecured URL"() {
        when: "Accessing an unsecured URL without"
        HttpResponse response = client.toBlocking().exchange(HttpRequest.GET("/tester"), String)

        then: "Access to be granted"
        response.status == HttpStatus.OK
        response.body() == "Hello Tester"
    }

    void "test secured URL"() {
        when: "Accessing a secured URL without credentials"
        client.toBlocking().exchange(HttpRequest.GET("/secured/tester"), String)

        then: "401 should be returned"
        HttpClientResponseException e = thrown()
        e.status == HttpStatus.UNAUTHORIZED
    }

    void "test secured URL access with credentials"() {
        when: "Accessing a secured URL with correct credentials"
        HttpRequest request = HttpRequest.GET("/secured/tester")
                .basicAuth("test", "password")
        HttpResponse response = client.toBlocking().exchange(request, String)

        then: "the request should be successful"
        response.status == HttpStatus.OK
    }

    @MockBean(PasswordEncoderService.class)
    PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = Stub {
            matches("password", "encodedPassword") >> true
        }
    }
}
