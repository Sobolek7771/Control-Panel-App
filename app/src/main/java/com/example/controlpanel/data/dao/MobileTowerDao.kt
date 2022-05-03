package com.example.controlpanel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower

@Dao
interface MobileTowerDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMobileTower(mobileTower: MobileTower)

    @Query("SELECT * FROM mobile_tower WHERE isLocal = 1 ORDER BY id")
    fun readAllLocalData():LiveData<List<MobileTower>>

    @Query("SELECT COUNT(*) FROM mobile_tower WHERE isLocal = 1")
    fun countAllLocalData():LiveData<Int>

    @Query("SELECT * FROM mobile_tower WHERE isLocal = 0 ORDER BY id")
    fun readAllServerData():LiveData<List<MobileTower>>

    @Query("SELECT COUNT(*) FROM mobile_tower WHERE isLocal = 0")
    fun countAllServerData():LiveData<Int>

    @Update
    suspend fun updateMobileTower(mobileTower: MobileTower)
}