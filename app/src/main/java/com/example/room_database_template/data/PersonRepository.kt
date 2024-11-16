package com.example.room_database_template.data

import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao){
  val allPeople: Flow<List<Person>> = personDao.getEveryone()
  
  suspend fun insertPerson(person: Person){
    personDao.insertPerson(person)
  }
  
  suspend fun deletePerson(person: Person){
    personDao.deleterPerson(person)
  }
}