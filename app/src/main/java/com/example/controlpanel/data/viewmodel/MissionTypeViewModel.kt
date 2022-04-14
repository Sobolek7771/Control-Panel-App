package com.example.controlpanel.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlpanel.data.database.MissionDatabase
import com.example.controlpanel.data.model.MissionType
import com.example.controlpanel.data.repository.MissionTypeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MissionTypeViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<MissionType>>
    private val repository: MissionTypeRepository

    init {
        val missionTypeDao = MissionDatabase.getDatabase(application).MissionTypeDao()
        repository = MissionTypeRepository(missionTypeDao)
        readAllData = repository.readAllData
    }

    fun addMissionType(missionType: MissionType){
        viewModelScope.launch(Dispatchers.IO){
            repository.addMissionType(missionType)
        }
    }
}