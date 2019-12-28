package micronaut.scheduled.exceptions

import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Replaces
import io.micronaut.scheduling.DefaultTaskExceptionHandler
import io.micronaut.scheduling.TaskExceptionHandler

import javax.annotation.Nonnull
import javax.annotation.Nullable
import javax.inject.Singleton

@Singleton
@Replaces(DefaultTaskExceptionHandler.class)
@Slf4j
class HelloWorldTaskExceptionHandler implements TaskExceptionHandler<Object, Throwable> {

    @Override
    void handle(@Nullable Object bean, @Nonnull Throwable throwable) {
        log.error("${bean.toString()} threw an exception ${throwable.message}")
        log.info("You can do whatever you want with the thrown exception in here")
    }
}
