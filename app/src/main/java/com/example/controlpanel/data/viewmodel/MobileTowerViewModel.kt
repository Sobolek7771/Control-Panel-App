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

    val readAllData: LiveData<List<MobileTower>>
    private val repository: MobileTowerRepository

    init {
        val mobileTowerDao = MissionDatabase.getDatabase(application).MobileTowerDao()
        repository = MobileTowerRepository(mobileTowerDao)
        readAllData = repository.readAllData
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