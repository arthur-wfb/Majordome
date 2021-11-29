package com.tooru.data.interactor

import android.util.Log
import com.tooru.domain.interactor.EventsInteractor
import com.tooru.domain.model.Event
import com.tooru.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsInteractorImpl @Inject constructor(private val repository: EventRepository) :
    EventsInteractor {
    override suspend fun getEvents(): List<Event> {
        return repository.getEvents()
    }

    override suspend fun createEvent(event: Event) {
        repository.createEvent(event)
    }
}