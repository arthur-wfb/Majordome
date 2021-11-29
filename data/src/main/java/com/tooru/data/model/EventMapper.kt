package com.tooru.data.model

import com.tooru.domain.model.Event
import org.joda.time.DateTime

class EventEntityMapper {

    companion object {
        fun mapToData(event: Event): EventEntity =
            EventEntity(event.id, event.title, event.date.millis / 1000, event.description)

        fun mapToDomain(event: EventEntity): Event =
            Event(event.id, event.title, DateTime().withMillis(event.date * 1000), event.description)
    }
}

