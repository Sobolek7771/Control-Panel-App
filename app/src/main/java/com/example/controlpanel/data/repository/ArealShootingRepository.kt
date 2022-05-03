package com.example.controlpanel.data.repository

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.ArealShootingDao
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting

class ArealShootingRepository(private val arealShootingDao: ArealShootingDao) {

    val readAllLocalData: LiveData<List<ArealShooting>> = arealShootingDao.readAllLocalData()
    val countAllLocalData: LiveData<Int> = arealShootingDao.countAllLocalData()
    val readAllServerData: LiveData<List<ArealShooting>> = arealShootingDao.readAllServerData()
    val countAllServerData: LiveData<Int> = arealShootingDao.countAllServerData()

    suspend fun addArealShooting(arealShooting: ArealShooting){
        arealShootingDao.addArealShooting(arealShooting)
    }

    suspend fun updateArealShooting(arealShooting: ArealShooting){
        arealShootingDao.updateArealShooting(arealShooting)
    }
}