package com.example.controlpanel.data.repository

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.MobileTowerDao
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower

class MobileTowerRepository (private val mobileTowerDao: MobileTowerDao){

    val readAllData: LiveData<List<MobileTower>> = mobileTowerDao.readAllData()

    suspend fun addMobileTower(mobileTower: MobileTower){
        mobileTowerDao.addMobileTower(mobileTower)
    }

    suspend fun updateMobileTower(mobileTower: MobileTower){
        mobileTowerDao.updateMobileTower(mobileTower)
    }
}