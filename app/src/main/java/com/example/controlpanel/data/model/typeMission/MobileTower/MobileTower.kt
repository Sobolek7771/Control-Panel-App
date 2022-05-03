package com.example.controlpanel.data.model.typeMission.MobileTower

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "mobile_tower")
data class MobileTower(
    //general settings
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val missionType: String,
    val isLocal: Boolean,
    val speed: Int,
    val rounding: Int,
    //special settings
    val radius: Int,
    val shootingPointsNumber: Int,
    val height: Int,
    val tiltAngle: Int,
    //mission settings (данные которые используются для отрисовки миссии в MissionList)
    val name: String,
    val address: String,
    val creationDate: String,
    val dotsNumber: Int,
    val flightTime: Int,
    val distance: Int,
):Parcelable