package com.example.controlpanel.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlpanel.data.database.MissionDatabase
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower
import com.example.controlpanel.data.repository.MobileTowerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MobileTowerViewModel(application: Application): AndroidViewModel(application) {

    val readAllLocalData: LiveData<List<MobileTower>>
    val countAllLocalData: LiveData<Int>
    val readAllServerData: LiveData<List<MobileTower>>
    val countAllServerData: LiveData<Int>
    private val repository: MobileTowerRepository

    init {
        val mobileTowerDao = MissionDatabase.getDatabase(application).MobileTowerDao()
        repository = MobileTowerRepository(mobileTowerDao)
        readAllLocalData = repository.readAllLocalData
        countAllLocalData = repository.countAllLocalData
        readAllServerData = repository.readAllServerData
        countAllServerData = repository.countAllServerData
    }

    fun addMobileTower(mobileTower: MobileTower){
        viewModelScope.launch(Dispatchers.IO){
            repository.addMobileTower(mobileTower)
        }
    }

    fun updateMobileTower(mobileTower: MobileTower){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateMobileTower(mobileTower)
        }
    }
}