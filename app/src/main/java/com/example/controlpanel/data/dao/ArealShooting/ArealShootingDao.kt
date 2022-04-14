package com.example.controlpanel.data.dao.ArealShooting

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.controlpanel.data.model.ArealShooting.ArealShooting

@Dao
interface ArealShootingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addArealShooting(arealShooting: ArealShooting)

    @Query("SELECT * FROM areal_shooting ORDER BY id")
    fun readAllData(): LiveData<List<ArealShooting>>
}