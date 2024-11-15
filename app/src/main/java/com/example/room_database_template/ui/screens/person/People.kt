package com.example.room_database_template.ui.screens.person

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun People(personViewModel: PersonViewModel){
  val listPeople by personViewModel.allPeople.observeAsState(listOf())
  
  LazyColumn {
    items(listPeople.size) { index ->
      Row {
        Text(text = listPeople[index].name)
      }
    }
  }
}