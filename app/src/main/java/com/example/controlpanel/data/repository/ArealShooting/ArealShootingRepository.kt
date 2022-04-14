package com.example.controlpanel.data.repository.ArealShooting

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.ArealShooting.ArealShootingDao
import com.example.controlpanel.data.model.ArealShooting.ArealShooting

class ArealShootingRepository(private val arealShootingDao: ArealShootingDao) {

    val readAllData: LiveData<List<ArealShooting>> = arealShootingDao.readAllData()

    suspend fun addArealShooting(arealShooting: ArealShooting){
        arealShootingDao.addArealShooting(arealShooting)
    }
}