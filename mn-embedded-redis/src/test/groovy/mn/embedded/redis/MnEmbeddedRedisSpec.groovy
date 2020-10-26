package mn.embedded.redis

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class MnEmbeddedRedisSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    @Shared @AutoCleanup @Inject @Client("/greeting")
    RxHttpClient client

    void 'test creating a new greeting'() {
        when: 'create new french greeting'
        HttpRequest request =  HttpRequest.POST('/', [language: 'fr', greeting: 'Bonjour'])
        HttpResponse response = client.toBlocking().exchange(request, String)

        then: 'greeting should be created and returned'
        response.body() == 'Bonjour'
    }

    void 'test retrieving a greeting'() {
        when: 'Retrieve the french greeting'
        HttpResponse response = client.toBlocking().exchange(HttpRequest.GET('/fr'), String)

        then: 'The greeting should be returned'
        response.body() == 'Bonjour'
    }

}
