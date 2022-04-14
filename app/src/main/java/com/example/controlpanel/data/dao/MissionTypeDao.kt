package com.example.controlpanel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.controlpanel.data.model.MissionType

@Dao
interface MissionTypeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMissionType(missionType: MissionType)

    @Query("SELECT * FROM mission_type ORDER BY id")
    fun readAllData(): LiveData<List<MissionType>>
}