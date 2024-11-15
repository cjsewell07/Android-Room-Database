package com.example.room_database_template.data

import Person
import PersonDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
  version = 1,
  entities = [
   Person::class
  ]
)
abstract class MasterRoomDatabase: RoomDatabase(){
  abstract fun personDao(): PersonDao
  
  private class MasterDatabaseCallback(
    private val scope: CoroutineScope
  ) : RoomDatabase.Callback(){
    override fun onCreate(db: SupportSQLiteDatabase) {
      super.onCreate(db)
      INSTANCE?.let { database ->
        // Runs this when the meal database is built for creation.
        scope.launch {
          populateDatabase(database.personDao())
        }
      }
    }
    
    suspend fun populateDatabase(personDao: PersonDao) {
    
    }
  }
  
  companion object {
    @Volatile
    private var INSTANCE: MasterRoomDatabase? = null
    
    fun getDatabase(context: Context, scope: CoroutineScope): MasterRoomDatabase {
      return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          MasterRoomDatabase::class.java,
          "master_db"
        )
          .addCallback(MasterDatabaseCallback(scope))
          .build()
        
        INSTANCE = instance
        instance
      }
    }
  }
}