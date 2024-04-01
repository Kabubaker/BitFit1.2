package com.example.bitfit1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_data_table")
data class SleepEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "type") val typeEnt: String,
    @ColumnInfo(name = "feeling") val feelingEnt: String,
    @ColumnInfo(name = "hours") val hoursEnt: Double,
    @ColumnInfo(name = "reason") val reasonEnt: String
)