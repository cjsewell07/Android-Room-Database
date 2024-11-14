import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class Person(
  @PrimaryKey val name: String
)