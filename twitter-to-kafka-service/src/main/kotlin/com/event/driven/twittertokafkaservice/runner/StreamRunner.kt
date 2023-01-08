package com.event.driven.twittertokafkaservice.runner

import twitter4j.TwitterException

interface StreamRunner {
    @Throws(TwitterException::class)
    fun start()
}