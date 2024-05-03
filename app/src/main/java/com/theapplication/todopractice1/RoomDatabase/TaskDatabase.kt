package com.theapplication.todopractice1.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TaskEntity::class], version = 1)
abstract class  TaskDatabase : RoomDatabase() {
    abstract fun taskdao():TaskDao
}