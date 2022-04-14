package com.example.controlpanel.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.controlpanel.data.dao.ArealShooting.ArealShootingDao
import com.example.controlpanel.data.dao.FreeFlight.FreeFlightDao
import com.example.controlpanel.data.dao.MissionTypeDao
import com.example.controlpanel.data.dao.MobileTower.MobileTowerDao
import com.example.controlpanel.data.model.ArealShooting.ArealShooting
import com.example.controlpanel.data.model.FreeFlight.FreeFlight
import com.example.controlpanel.data.model.FreeFlight.Waypoint.Waypoint
import com.example.controlpanel.data.model.MissionType
import com.example.controlpanel.data.model.MobileTower.MobileTower


@Database(entities = [
    MissionType::class,
    ArealShooting::class,
    FreeFlight::class,
    MobileTower::class,
    Waypoint::class],
    version = 1, exportSchema = false)
abstract class MissionDatabase: RoomDatabase() {

    abstract fun MissionTypeDao(): MissionTypeDao
        abstract fun ArealShootingDao(): ArealShootingDao
        abstract fun MobileTowerDao(): MobileTowerDao
        abstract fun FreeFlightDao(): FreeFlightDao


    companion object{
        @Volatile
        private var INSTANCE: MissionDatabase? = null

        fun getDatabase(context: Context):MissionDatabase{
            val tempInstances = INSTANCE
            if (tempInstances != null){
                return tempInstances
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MissionDatabase::class.java,
                    "mission_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}