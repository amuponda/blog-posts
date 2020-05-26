package com.example

import groovy.util.logging.Slf4j
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.scheduling.io.watch.event.FileChangedEvent

import javax.inject.Singleton

@Singleton
@Slf4j
class FileChangedEventListener implements ApplicationEventListener<FileChangedEvent> {
    @Override
    void onApplicationEvent(FileChangedEvent event) {
        log.info("A file has been changed.")
    }
}
