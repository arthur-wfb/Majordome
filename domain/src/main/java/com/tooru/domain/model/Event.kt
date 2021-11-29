package com.tooru.domain.model

import org.joda.time.DateTime

data class Event(
    val id: Int?,
    val title: String,
    val date: DateTime,
    val description: String,
)