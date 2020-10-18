package mn.zalando.logbook

import io.micronaut.context.annotation.Requires
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import io.micronaut.http.netty.channel.ChannelPipelineCustomizer
import io.netty.channel.ChannelPipeline
import org.zalando.logbook.Logbook
import org.zalando.logbook.netty.LogbookClientHandler
import org.zalando.logbook.netty.LogbookServerHandler

import javax.inject.Singleton

@Requires(beans = Logbook.class)
@Singleton
class LogbookPipelineCustomizer implements BeanCreatedEventListener<ChannelPipelineCustomizer> {

    private final Logbook logbook

    LogbookPipelineCustomizer(Logbook logbook) {
        this.logbook = logbook
    }

    @Override
    ChannelPipelineCustomizer onCreated(BeanCreatedEvent<ChannelPipelineCustomizer> event) {
        ChannelPipelineCustomizer customizer = event.getBean()
        if (customizer.isServerChannel()) {
            customizer.doOnConnect({ ChannelPipeline pipeline ->
                pipeline.addAfter(
                        ChannelPipelineCustomizer.HANDLER_HTTP_SERVER_CODEC,
                        "logbook",
                        new LogbookServerHandler(logbook)
                )
                return pipeline
            })
        } else {
            customizer.doOnConnect({ ChannelPipeline pipeline ->
                pipeline.addAfter(
                        ChannelPipelineCustomizer.HANDLER_HTTP_SERVER_CODEC,
                        "logbook",
                        new LogbookClientHandler(logbook))
                return pipeline
            })
        }
        return customizer
    }
}
