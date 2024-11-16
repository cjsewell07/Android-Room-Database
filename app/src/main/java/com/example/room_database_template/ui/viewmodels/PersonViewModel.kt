package com.example.room_database_template.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.room_database_template.data.Person
import com.example.room_database_template.data.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: PersonRepository) : ViewModel(){
  val allPeople: LiveData<List<Person>> = repository.allPeople.asLiveData()
  
  fun insertPerson(person: Person) = viewModelScope.launch {
    repository.insertPerson(person)
  }
  
  fun deletePerson(person: Person) = viewModelScope.launch {
    repository.deletePerson(person)
  }
}