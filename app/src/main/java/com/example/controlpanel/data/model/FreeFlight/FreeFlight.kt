package com.example.controlpanel.data.model.FreeFlight

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "free_flight")
data class FreeFlight(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val address : String
)
