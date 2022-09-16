package com.isabela.kafkaconsumerpoc.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.Date
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
data class TaskEntity(
    @Id
    val id: UUID,
    val name: String,
    val startDate: Date,
    val endDate: Date,
    val done: Boolean
)