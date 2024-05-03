package com.theapplication.todopractice1.RoomDatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(val repository: TaskRepository):ViewModel() {

    fun getalltask () = repository.getalltask().asLiveData(viewModelScope.coroutineContext)

    fun inserttask(taskEntity: TaskEntity){
        viewModelScope.launch {
            repository.inserttask(taskEntity)
        }
    }

    fun deletetask(taskEntity: TaskEntity){
        viewModelScope.launch {
            repository.deletetask(taskEntity)
        }
    }

}