package com.example.controlpanel.data.repository.MobileTower

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.MobileTower.MobileTowerDao
import com.example.controlpanel.data.model.MobileTower.MobileTower

class MobileTowerRepository (private val mobileTowerDao: MobileTowerDao){

    val readAllData: LiveData<List<MobileTower>> = mobileTowerDao.readAllData()

    suspend fun addMobileTower(mobileTower: MobileTower){
        mobileTowerDao.addMobileTower(mobileTower)
    }
}