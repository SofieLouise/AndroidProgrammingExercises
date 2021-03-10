package com.programming.adnroid.sdu.activities_exercise_1.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey
    val uid: Int = 0,
    var name: String? = null,
    var address: String? = null,
    var birthday: String? = null
)