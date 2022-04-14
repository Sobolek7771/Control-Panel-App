package com.example.controlpanel.data.viewmodel.ArealShooting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlpanel.data.database.MissionDatabase
import com.example.controlpanel.data.model.ArealShooting.ArealShooting
import com.example.controlpanel.data.repository.ArealShooting.ArealShootingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArealShootingViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<ArealShooting>>
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
}