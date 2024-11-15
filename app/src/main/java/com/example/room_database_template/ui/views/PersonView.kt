package com.example.room_database_template.ui.views

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PersonView(
  personViewModel: PersonViewModel
){
  val allPeople by personViewModel.allPeople.observeAsState(listOf())
  
  
}