package com.isabela.kafkaconsumerpoc.deserializer

import com.isabela.kafkaconsumerpoc.proto.TaskPBOuterClass.TaskPB
import org.apache.kafka.common.serialization.Deserializer
import org.slf4j.LoggerFactory

class TaskDeserializer : Deserializer<TaskPB> {

    private val log = LoggerFactory.getLogger(javaClass)
    override fun deserialize(topic: String?, data: ByteArray?): TaskPB {
        log.info("Deserializing...")
        return TaskPB.parseFrom(data)
    }
}