package com.theapplication.todopractice1.RoomDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TaskEntity(
    val title:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
)
