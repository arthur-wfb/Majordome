package com.tooru.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: Long,
    @ColumnInfo(name = "description") val description: String
)

