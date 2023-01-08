package com.event.driven.twittertokafkaservice

import com.event.driven.twittertokafkaservice.runner.StreamRunner
import com.event.driven.twittertokafkaservice.runner.TwitterKafkaStreamRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TwitterToKafkaServiceApplication

fun main(args: Array<String>) {
    runApplication<TwitterToKafkaServiceApplication>(*args)
}
