package com.example.controlpanel.data.repository

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.ArealShootingDao
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting

class ArealShootingRepository(private val arealShootingDao: ArealShootingDao) {

    val readAllData: LiveData<List<ArealShooting>> = arealShootingDao.readAllData()

    suspend fun addArealShooting(arealShooting: ArealShooting){
        arealShootingDao.addArealShooting(arealShooting)
    }

    suspend fun updateArealShooting(arealShooting: ArealShooting){
        arealShootingDao.updateArealShooting(arealShooting)
    }
}