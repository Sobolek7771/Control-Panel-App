package com.example.controlpanel.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlpanel.data.database.MissionDatabase
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.repository.ArealShootingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArealShootingViewModel(application: Application): AndroidViewModel(application) {

    val readAllLocalData: LiveData<List<ArealShooting>>
    val countAllLocalData: LiveData<Int>
    val readAllServerData: LiveData<List<ArealShooting>>
    val countAllServerData: LiveData<Int>
    private val repository: ArealShootingRepository

    init {
        val arealShootingDao = MissionDatabase.getDatabase(application).ArealShootingDao()
        repository = ArealShootingRepository(arealShootingDao)
        readAllLocalData = repository.readAllLocalData
        countAllLocalData = repository.countAllLocalData
        readAllServerData = repository.readAllServerData
        countAllServerData = repository.countAllServerData
    }

    fun addArealShooting(arealShooting: ArealShooting){
        viewModelScope.launch(Dispatchers.IO){
            repository.addArealShooting(arealShooting)
        }
    }
    fun updateArealShooting(arealShooting: ArealShooting){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateArealShooting(arealShooting)
        }
    }

}