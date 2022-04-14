package com.example.controlpanel.data.dao.FreeFlight

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.controlpanel.data.model.FreeFlight.FreeFlight

@Dao
interface FreeFlightDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFreeFlight(freeFlight: FreeFlight)

    @Query("SELECT * FROM free_flight ORDER BY id")
    fun readAllData(): LiveData<List<FreeFlight>>

    //нужно работать над selectом для отображения всего полета
}