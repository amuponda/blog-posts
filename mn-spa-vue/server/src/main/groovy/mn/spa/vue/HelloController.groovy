package mn.spa.vue

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/")
class HelloController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/{name}")
    HttpResponse<String> hello(String name) {
        return HttpResponse.ok("Hello, " + name + "!")
    }
}
