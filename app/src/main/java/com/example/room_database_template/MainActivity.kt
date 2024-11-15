package com.example.room_database_template

import DatabaseTemplate
import PersonRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.room_database_template.data.MasterRoomDatabase
import com.example.room_database_template.ui.theme.RoomDatabaseTemplateTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MainActivity : ComponentActivity() {
  val applicationScope = CoroutineScope(SupervisorJob())
  val masterDatabase by lazy{ MasterRoomDatabase.getDatabase(this, applicationScope)}
  
  val personRepository by lazy { PersonRepository(masterDatabase.personDao()) }
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      RoomDatabaseTemplateTheme {
        DatabaseTemplate(personRepository = personRepository)
      }
    }
  }
}