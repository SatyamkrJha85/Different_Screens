package com.theapplication.todopractice1.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Query("SELECT * FROM TaskEntity")
    fun getalltask(): Flow<List<TaskEntity>>

    @Insert
   suspend fun inserttask(taskEntity: TaskEntity)

   @Delete
   suspend fun deletetask(taskEntity: TaskEntity)
}