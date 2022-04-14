package com.example.controlpanel.data.repository

import androidx.lifecycle.LiveData
import com.example.controlpanel.data.dao.MissionTypeDao
import com.example.controlpanel.data.model.MissionType

class MissionTypeRepository(private val missionTypeDao: MissionTypeDao) {

    val readAllData: LiveData<List<MissionType>> = missionTypeDao.readAllData()

    suspend fun addMissionType(missionType: MissionType){
        missionTypeDao.addMissionType(missionType)
    }
}