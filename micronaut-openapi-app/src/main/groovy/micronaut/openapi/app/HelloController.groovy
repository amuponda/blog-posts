package micronaut.openapi.app

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Single


@Controller("/hello")
class HelloController {

    @Get(uri = "/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> index(String name) {
        return Single.just("Hello ${name}!")
    }
}