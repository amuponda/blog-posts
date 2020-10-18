package mn.zalando.logbook

import io.micronaut.context.annotation.Factory
import org.zalando.logbook.Logbook

import javax.inject.Singleton

@Factory
class BeanFactory {

    @Singleton
    Logbook logbook() {
        Logbook.create()
    }
}
