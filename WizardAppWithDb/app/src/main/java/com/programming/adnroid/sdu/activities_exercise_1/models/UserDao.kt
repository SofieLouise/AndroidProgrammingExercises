package com.programming.adnroid.sdu.activities_exercise_1.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @get:Query("SELECT * FROM user WHERE uid = 1")
    val user: User?

    @Update
    fun update(user:User?): Int

    @Insert
    fun insert(user: User?)

    @Query("SELECT COUNT(*) from user")
    fun countUsers(): Int
}