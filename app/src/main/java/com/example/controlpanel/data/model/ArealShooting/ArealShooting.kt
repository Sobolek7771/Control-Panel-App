package com.example.controlpanel.data.model.ArealShooting

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "areal_shooting")
data class ArealShooting(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val speed : Int,
    val rounding : Int,
    val resolution : Int,
    val height : Int,
    val longitudinalOverlap : Int,
    val shootingStep : Int,
    val transverseOverlap : Int,
    val tackStep : Int,
    val missionName : String
)
