package com.isabela.kafkaconsumerpoc.repository

import com.isabela.kafkaconsumerpoc.entity.TaskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository: CrudRepository<TaskEntity, UUID>