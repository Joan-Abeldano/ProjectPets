package com.example.projectpets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.projectpets.models.Pet
import com.example.projectpets.ui.screens.MyPetsScreen
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectpets.ui.screens.LoginScreen
import com.example.projectpets.ui.screens.PetDetailScreen
import com.example.projectpets.ui.screens.SplashScreen
import com.example.projectpets.ui.screens.VaccinesControlScreen
import com.example.projectpets.ui.theme.ProjectPetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjectPetsTheme {
                val pets = listOf(
                    Pet("Pablo","Es un perro lol","26/54/2154","Perro"),
                    Pet("Pepito","Es un perro loll","26/54/2154","Perro"),
                    Pet("Peter","Es un perro lolll","26/54/2154","Perro"),
                    Pet("Pony","Es un perro lollll","26/54/2154","Perro"),
                    Pet("PP","Es un perro lolllll","26/54/2154","Perro"),
                    Pet("PPP","Es un perro lollllll","26/54/2154","Perro"),
                    Pet("Priest","Es un perro lolllllll","26/54/2154","Perro"),
                    Pet("Pablo","Es un perro lol","26/54/2154","Perro"),
                    Pet("Pepito","Es un perro loll","26/54/2154","Perro"),
                    Pet("Peter","Es un perro lolll","26/54/2154","Perro"),
                    Pet("Pony","Es un perro lollll","26/54/2154","Perro"),
                    Pet("PP","Es un perro lolllll","26/54/2154","Perro"),
                    Pet("PPP","Es un perro lollllll","26/54/2154","Perro"),
                    Pet("Priest","Es un perro lolllllll","26/54/2154","Perro")
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyPetsScreen(pets)
                    /*
                    val dummyPhotos = listOf(
                        "https://placedog.net/500/400?id=1",
                        "https://placedog.net/500/400?id=2",
                        "https://placedog.net/500/400?id=3"
                    )

                    val dummyDescription = "Perla es una perrita de pelaje blanco, suave y brillante. Es pequeña, juguetona, muy leal e inteligente. Se unió a su familia a los 3 meses de vida y desde entonces llena el hogar de alegría con su ternura y energía."

                    PetDetailScreen(
                        petName = "Perla",
                        petDescription = dummyDescription,
                        petPhotos = dummyPhotos
                    )
                    Prueba para PetDetailScreen
                    */
                    // SplashScreen()
                   // LoginScreen()
                     VaccinesControlScreen()
                }
            }
        }
    }
}
