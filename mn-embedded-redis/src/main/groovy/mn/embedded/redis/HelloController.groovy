package mn.embedded.redis

import io.lettuce.core.api.StatefulRedisConnection
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/greeting")
class HelloController {

    private final StatefulRedisConnection<String, String> redisConnection

    HelloController(StatefulRedisConnection<String, String> redisConnection) {
        this.redisConnection = redisConnection
    }

    @Post("/")
    String createGreeting(@Body Map<String, String> payload) {
        redisConnection.sync().set(payload.language, payload.greeting)
        return payload.greeting
    }

    @Get("/{language}")
    String getGreeting(String language) {
        redisConnection.sync().get(language)
    }
}
