package com.example.controlpanel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower

@Dao
interface MobileTowerDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMobileTower(mobileTower: MobileTower)

    @Query("SELECT * FROM mobile_tower ORDER BY id")
    fun readAllData():LiveData<List<MobileTower>>

    @Update
    suspend fun updateMobileTower(mobileTower: MobileTower)
}