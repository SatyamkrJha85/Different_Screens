package com.theapplication.todopractice1.RoomDatabase

class TaskRepository(private val db:TaskDatabase) {


    fun getalltask () = db.taskdao().getalltask()

    suspend fun inserttask(taskEntity: TaskEntity){
        db.taskdao().inserttask(taskEntity)
    }

    suspend fun deletetask(taskEntity: TaskEntity){
        db.taskdao().deletetask(taskEntity)
    }
}