package com.event.driven.twittertokafkaservice.runner

import com.event.driven.twittertokafkaservice.listener.TwitterKafkaStatusListener
import jakarta.annotation.PreDestroy
import mu.KLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import twitter4j.FilterQuery
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory

@Component
class TwitterKafkaStreamRunner(
    @Value("\${twitter.keywords}")
    private val keywords: List<String>,
    private val twitterKafkaStatusListener: TwitterKafkaStatusListener
) : StreamRunner {

    private lateinit var twitterStream: TwitterStream

    override fun start() {
        twitterStream = TwitterStreamFactory.getSingleton()
        twitterStream.addListener(twitterKafkaStatusListener)
        addFilter()
    }

    @PreDestroy
    fun shutdown() {
        if (twitterStream != null) {
            logger.info { "Closing twitter stream" }
            twitterStream.shutdown()
        }
    }

    private fun addFilter() {
        val filterQuery = FilterQuery(*keywords.toTypedArray())
        twitterStream.filter(filterQuery)
        logger.info { "Started Filtering Twitter Stream For Keywords $keywords" }
    }

    companion object : KLogging()
}
