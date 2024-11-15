package com.example.room_database_template.ui.screens.person

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@SuppressLint("MutableCollectionMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPerson(
  viewModel: PersonViewModel,
  collectionPeople: () -> Unit
) {
  val coroutineScope = rememberCoroutineScope()
  var name by rememberSaveable { mutableStateOf("") }
  
}