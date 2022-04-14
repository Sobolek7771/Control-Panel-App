package com.example.controlpanel.data.model.MobileTower

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_tower")
data class MobileTower(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val speed : Int,
    val rounding : Int,
    val radius : Int,
    val shootingPointsNumber : Int,
    val height : Int,
    val tiltAngle : Int,
    val missionName : String
)
