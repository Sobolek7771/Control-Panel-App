package com.example.controlpanel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting

@Dao
interface ArealShootingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addArealShooting(arealShooting: ArealShooting)

    @Query("SELECT * FROM areal_shooting ORDER BY id")
    fun readAllData(): LiveData<List<ArealShooting>>

    @Update
    suspend fun updateArealShooting(arealShooting: ArealShooting)
}