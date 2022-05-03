package com.example.controlpanel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower

@Dao
interface ArealShootingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addArealShooting(arealShooting: ArealShooting)

    @Query("SELECT * FROM areal_shooting WHERE isLocal = 1 ORDER BY id")
    fun readAllLocalData(): LiveData<List<ArealShooting>>

    @Query("SELECT COUNT(*) FROM areal_shooting WHERE isLocal = 1")
    fun countAllLocalData():LiveData<Int>

    @Query("SELECT * FROM areal_shooting WHERE isLocal = 0 ORDER BY id")
    fun readAllServerData(): LiveData<List<ArealShooting>>

    @Query("SELECT COUNT(*) FROM areal_shooting WHERE isLocal = 0")
    fun countAllServerData():LiveData<Int>

    @Update
    suspend fun updateArealShooting(arealShooting: ArealShooting)
}