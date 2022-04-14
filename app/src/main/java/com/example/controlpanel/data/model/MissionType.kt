package com.example.controlpanel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mission_type")
data class MissionType(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val picId : Int
)
