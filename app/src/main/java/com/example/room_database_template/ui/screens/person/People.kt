package com.example.room_database_template.ui.screens.person

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun People(personViewModel: PersonViewModel){
  val listPeople by personViewModel.allPeople.observeAsState(listOf())
  
  Scaffold(
    topBar = {
      TopAppBar(
        colors = topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
          Text("Database Template")
        }
      )
    },
  ){ innerPadding ->
    Column (
      modifier = Modifier
        .padding(innerPadding)
    ) {
      Text("Hello, this is still under development")
      Text("Hello, this is still under development")
      LazyColumn {
        items(listPeople.size) { index ->
          Row {
            Text(text = listPeople[index].name)
          }
          Button(onClick = { /*TODO*/ }) {
            Text(text = "Remove Person")
          }
        }
      }
      Button(onClick = { /*TODO*/ }) {
        Text("Add Person")
      }
    }
  }
}