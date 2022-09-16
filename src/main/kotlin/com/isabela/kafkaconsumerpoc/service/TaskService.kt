package com.isabela.kafkaconsumerpoc.service

import com.isabela.kafkaconsumerpoc.entity.TaskEntity
import com.isabela.kafkaconsumerpoc.model.Task
import com.isabela.kafkaconsumerpoc.repository.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(
    private val repository: TaskRepository
) {

    fun save(task: Task) {
        val taskEntity = taskToEntity(task)
        repository.save(taskEntity)
    }

    fun findAll(): Iterable<TaskEntity> = repository.findAll()

    fun findById(taskId: UUID) = repository.findByIdOrNull(taskId)

    fun delete(taskId: UUID) {
        repository.deleteById(taskId)
    }

    private fun taskToEntity(task: Task): TaskEntity = TaskEntity(
        UUID.randomUUID(),
        task.name,
        task.startDate,
        task.endDate,
        task.done
    )
}