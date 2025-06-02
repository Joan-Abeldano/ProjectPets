package com.example.projectpets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
