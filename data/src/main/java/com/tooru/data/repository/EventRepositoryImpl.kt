package com.tooru.data.repository

import android.util.Log
import com.tooru.data.local.db.AppDatabase
import com.tooru.data.model.EventEntity
import com.tooru.data.model.EventEntityMapper
import com.tooru.data.model.EventEntityMapper.Companion.mapToDomain
import com.tooru.domain.model.Event
import com.tooru.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val appDatabase: AppDatabase
): EventRepository {

    override suspend fun getEvents(): List<Event> {
        Log.d("EventRepositoryImpl", "get Start")

        val a = appDatabase.eventDao().getAll()


        val b = a.map {
                e -> Log.d("EventRepositoryImpl", e.toString())
            mapToDomain(e)
        }

        return b
    }

    override suspend fun createEvent(event: Event) {
        Log.d("EventRepositoryImpl", "data model ${EventEntityMapper.mapToData(event)}")
        appDatabase.eventDao().insert(EventEntityMapper.mapToData(event))
        Log.d("EventRepositoryImpl", "after eventDao().insert(EventEntityMapper")


    }
}