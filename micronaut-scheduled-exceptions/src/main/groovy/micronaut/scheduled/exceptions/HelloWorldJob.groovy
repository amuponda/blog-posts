package micronaut.scheduled.exceptions

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.scheduling.annotation.Scheduled

import javax.inject.Singleton
import java.text.SimpleDateFormat

@CompileStatic
@Singleton
@Slf4j
class HelloWorldJob {

    @Scheduled(fixedDelay = "10s")
    void executeEveryTen() {
        throw new Exception("Test exception")
        log.info("Simple Job every 10 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()))
    }
}
