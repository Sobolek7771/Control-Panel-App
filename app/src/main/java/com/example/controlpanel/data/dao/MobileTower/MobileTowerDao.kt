package com.example.controlpanel.data.dao.MobileTower

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.controlpanel.data.model.MobileTower.MobileTower

@Dao
interface MobileTowerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMobileTower(mobileTower: MobileTower)

    @Query("SELECT * FROM mobile_tower ORDER BY id")
    fun readAllData():LiveData<List<MobileTower>>
}