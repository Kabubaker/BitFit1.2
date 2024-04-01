package com.example.bitfit1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {

    @Query("SELECT * FROM sleep_data_table")
    fun getAll(): Flow<List<SleepEntity>>

    @Insert
    fun insert(sleepData: List<SleepEntity>)

    @Query("DELETE FROM sleep_data_table")
    fun deleteAll()
}