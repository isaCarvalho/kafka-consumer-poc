package com.isabela.kafkaconsumerpoc.consumer

import com.isabela.kafkaconsumerpoc.model.Task
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.kafka.support.Acknowledgment

@Component
class Consumer {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${kafka.topics.product}"], groupId = "ppr")
    fun listenGroupFoo(task: Task, ack: Acknowledgment) {
        logger.info("Message received {}", task)
        ack.acknowledge()
    }
}