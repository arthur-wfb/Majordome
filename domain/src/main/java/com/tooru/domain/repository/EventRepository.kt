package com.tooru.domain.repository

import com.tooru.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun getEvents(): List<Event>

    suspend fun createEvent(event: Event)
}