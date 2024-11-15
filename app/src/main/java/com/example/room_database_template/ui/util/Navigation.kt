import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.room_database_template.ui.screens.person.People
import com.example.room_database_template.ui.screens.Screens
import com.example.room_database_template.ui.viewmodels.PersonViewModel

@Composable
fun DatabaseTemplate(
  personRepository: PersonRepository
){
  val navController = rememberNavController()
  val personViewModel = PersonViewModel(personRepository)
  
  NavHost(navController = navController, startDestination = Screens.People.name){
    composable(route = Screens.People.name){
      People(personViewModel = personViewModel)
    }
  }
}