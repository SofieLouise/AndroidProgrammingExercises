package com.programming.adnroid.sdu.activities_exercise_1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.programming.adnroid.sdu.activities_exercise_1.models.User
import com.programming.adnroid.sdu.activities_exercise_1.models.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
               INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user-database")
                       .allowMainThreadQueries()
                       .build()
            }
            return INSTANCE
        }
    }
}