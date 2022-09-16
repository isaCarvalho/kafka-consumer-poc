package com.isabela.kafkaconsumerpoc.controller

import com.isabela.kafkaconsumerpoc.entity.TaskEntity
import com.isabela.kafkaconsumerpoc.service.TaskService
import com.isabela.kafkaconsumerpoc.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("tasks")
class TaskController(
    private val service: TaskService
) {

    @GetMapping
    fun findAll(): Iterable<TaskEntity> = service.findAll()

    @GetMapping("/{taskId}")
    fun find(@PathVariable taskId: UUID) = service.findById(taskId) ?:
        throw ResourceNotFoundException("Could not find task [id=$taskId]")
}