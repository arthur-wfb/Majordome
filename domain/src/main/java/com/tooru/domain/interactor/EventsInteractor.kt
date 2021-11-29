package com.tooru.domain.interactor

import com.tooru.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface EventsInteractor {
    suspend fun getEvents(): List<Event>

    suspend fun createEvent(event: Event)
}