package com.isabela.kafkaconsumerpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaConsumerPocApplication

fun main(args: Array<String>) {
	runApplication<KafkaConsumerPocApplication>(*args)
}
