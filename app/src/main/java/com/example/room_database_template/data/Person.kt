package com.example.room_database_template.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class Person(
  @PrimaryKey val name: String
)