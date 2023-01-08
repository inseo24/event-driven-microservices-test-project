package com.event.driven.twittertokafkaservice.component

import com.event.driven.twittertokafkaservice.runner.StreamRunner
import jakarta.annotation.PostConstruct
import mu.KLogging
import org.springframework.stereotype.Component

@Component
class Runner(
    private val streamRunner: StreamRunner
) {
    @PostConstruct
    fun runnerStart() {
        streamRunner.start()
    }

    companion object: KLogging()
}
