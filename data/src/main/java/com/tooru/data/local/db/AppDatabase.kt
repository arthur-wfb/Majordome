package com.tooru.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tooru.data.local.db.dao.EventDao
import com.tooru.data.model.EventEntity

@Database(entities = [EventEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}