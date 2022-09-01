package com.isabela.kafkaconsumerpoc.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.isabela.kafkaconsumerpoc.model.Task
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import org.slf4j.LoggerFactory
import kotlin.text.Charsets.UTF_8

class TaskDeserializer : Deserializer<Task> {

    private val objectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(javaClass)
    override fun deserialize(topic: String?, data: ByteArray?): Task {
        log.info("Deserializing...")
        return objectMapper.readValue(
            String(
                data ?: throw SerializationException("Error when deserializing bytes"),
                UTF_8
            ), Task::class.java
        )
    }
}