package com.isabela.kafkaconsumerpoc.consumer

import com.isabela.kafkaconsumerpoc.model.Task
import com.isabela.kafkaconsumerpoc.proto.TaskPBOuterClass.TaskPB
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import org.springframework.kafka.support.Acknowledgment
import java.sql.Date
import java.time.Instant

@Component
class Consumer {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${kafka.topics.task}"], groupId = "ppr")
    fun listenGroupFoo(taskPB: TaskPB, ack: Acknowledgment) {
        logger.info("Message received {}", taskPB)

        val startDateInstant = Instant.ofEpochSecond(taskPB.startDate.seconds)
        val endDateInstant = Instant.ofEpochSecond(taskPB.endDate.seconds)

        val task = Task(
            taskPB.name,
            Date.from(startDateInstant),
            Date.from(endDateInstant),
            taskPB.done
        )

        logger.info("Task model {}", task)
        ack.acknowledge()
    }
}