package com.event.driven.twittertokafkaservice.listener

import mu.KLogging
import org.springframework.stereotype.Component
import twitter4j.Status
import twitter4j.StatusAdapter

@Component
class TwitterKafkaStatusListener : StatusAdapter() {

    companion object : KLogging()

    override fun onStatus(status: Status?) {
        logger.info { "Twitter Status with text ${status!!.text}" }
    }
}
