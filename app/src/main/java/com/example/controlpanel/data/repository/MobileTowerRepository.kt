package com.example.controlpanel.data.repository

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.MobileTowerDao
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower

class MobileTowerRepository (private val mobileTowerDao: MobileTowerDao){

    val readAllLocalData: LiveData<List<MobileTower>> = mobileTowerDao.readAllLocalData()
    val countAllLocalData: LiveData<Int> = mobileTowerDao.countAllLocalData()
    val readAllServerData: LiveData<List<MobileTower>> = mobileTowerDao.readAllServerData()
    val countAllServerData: LiveData<Int> = mobileTowerDao.countAllServerData()

    suspend fun addMobileTower(mobileTower: MobileTower){
        mobileTowerDao.addMobileTower(mobileTower)
    }

    suspend fun updateMobileTower(mobileTower: MobileTower){
        mobileTowerDao.updateMobileTower(mobileTower)
    }
}