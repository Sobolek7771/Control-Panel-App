package com.example.controlpanel.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.controlpanel.data.dao.ArealShootingDao
import com.example.controlpanel.data.dao.MobileTowerDao
import com.example.controlpanel.data.model.typeMission.ArealShooting.ArealShooting
import com.example.controlpanel.data.model.typeMission.MobileTower.MobileTower


@Database(entities = [
    ArealShooting::class,
    MobileTower::class],
    version = 2, exportSchema = false)
abstract class MissionDatabase: RoomDatabase() {

    abstract fun ArealShootingDao(): ArealShootingDao
    abstract fun MobileTowerDao(): MobileTowerDao

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