package com.example.controlpanel.data.model.typeMission.ArealShooting

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "areal_shooting")
data class ArealShooting(
    //general settings
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val missionType: String,
    val speed : Int,
    val rounding : Int,
    //special settings
    val resolution : Int,
    val height : Int,
    val longitudinalOverlap : Int,
    val shootingStep : Int,
    val transverseOverlap : Int,
    val tackStep : Int,
    //mission settings (данные которые используются для отрисовки миссии в MissionList)
    val name : String,
    val address : String,
    val creationDate : String,
    val dotsNumber : Int,
    val flightTime : Int,
    val distance : Int,
): Parcelable