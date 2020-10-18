package mn.zalando.logbook

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class HelloController {

    @Get("/")
    String hello() {
        "Hello World"
    }
}
