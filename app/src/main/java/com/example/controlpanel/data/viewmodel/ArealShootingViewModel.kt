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

    val readAllData: LiveData<List<ArealShooting>>
    private val repository: ArealShootingRepository

    init {
        val arealShootingDao = MissionDatabase.getDatabase(application).ArealShootingDao()
        repository = ArealShootingRepository(arealShootingDao)
        readAllData = repository.readAllData
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