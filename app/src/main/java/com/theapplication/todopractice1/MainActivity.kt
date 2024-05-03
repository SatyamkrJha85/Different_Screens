package com.theapplication.todopractice1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.theapplication.todopractice1.RoomDatabase.DashBoard
import com.theapplication.todopractice1.RoomDatabase.Emoji
import com.theapplication.todopractice1.RoomDatabase.TaskDatabase
import com.theapplication.todopractice1.RoomDatabase.TaskEntity
import com.theapplication.todopractice1.RoomDatabase.TaskRepository
import com.theapplication.todopractice1.RoomDatabase.TaskViewModel
import com.theapplication.todopractice1.ui.theme.TodoPractice1Theme

class MainActivity : ComponentActivity() {


    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            name = "task.database"
        ).build()
    }

    val viewModel by viewModels<TaskViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TaskViewModel(TaskRepository(db)) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoPractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = "Home"){
                        composable("Home"){
                            ScaffAddNote(viewModel = viewModel,navController)
                        }
                        composable("Dashboard"){
                            DashBoard(navController = navController)
                        }
                        composable("Emoji"){
                            Emoji()
                        }
                    }


                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffAddNote(viewModel: TaskViewModel,navController: NavController) {

    var opendialog by remember {
        mutableStateOf(false)
    }

    val taskListState by viewModel.getalltask().observeAsState(initial = emptyList())

    val taskList = taskListState

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text(text = "Add Task") },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate("Dashboard")
            }) {
                Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = null)
            }
        }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                opendialog = true
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
            }
        },
        content = {


                LazyColumn(
                    modifier = Modifier.padding(paddingValues = it)
                ) {
                    items(taskList){task->
                        TextComponent(title = task.title){
                            viewModel.deletetask(task)
                        }
                    }
                }

        }
    )
    if (opendialog){
        DialogBox(viewModel = viewModel) {
            opendialog=false
        }
    }

}

@Composable
fun DialogBox(viewModel: TaskViewModel,onclose: () -> Unit) {
    var title by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current


    val task = TaskEntity(title)
    AlertDialog(onDismissRequest = { onclose() },
        confirmButton = {
            ElevatedButton(onClick = {

                if(title.isNotEmpty() ){
                    viewModel.inserttask(task)
                    onclose()
                    Toast.makeText(context,"ADDED $title",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(context,"Box is Empty",Toast.LENGTH_LONG).show()

                }


            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            ElevatedButton(onClick = {
                onclose()
            }) {
                Text(text = "Dismiss")
            }
        },
        title = { Text(text = "Add Title")},
        text = {
            TextField(value = title, onValueChange ={title=it} )
        }
        
    )
}

@Composable
fun TextComponent(title:String,ondelete:()->Unit) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = title, color = Color.Blue)
            IconButton(onClick = {
                ondelete()
                Toast.makeText(context,"DELETED $title",Toast.LENGTH_LONG).show()
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription =null )
            }
        }
    }
}


