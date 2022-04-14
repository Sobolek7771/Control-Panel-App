package com.example.controlpanel.data.model.FreeFlight.Waypoint

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "waypoint")
data class Waypoint(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val idFreeFlight : Int,
    val idPreviousWaypoint : Int,
    val idNextWaypoint : Int,
    val height : Int,
    val speed : Int,
    val course : Int
)
