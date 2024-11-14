import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao{
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertPerson(vararg person: Person)
  
  @Update
  suspend fun updatePerson(vararg person: Person)
  
  @Delete
  suspend fun deleterPerson(vararg person: Person)
  
  @Query("SELECT * FROM people")
  fun getEveryone(): Flow<List<Person>>
}