package com.example.projectpets.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectpets.models.Pet
import com.example.projectpets.ui.screens.LoginScreen
import com.example.projectpets.ui.screens.MyPetsScreen
import com.example.projectpets.ui.screens.PetDetailScreen
import com.example.projectpets.ui.screens.SplashScreen
import com.example.projectpets.ui.screens.VaccinesControlScreen

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val MY_PETS = "my_pets"
    const val PET_DETAILS = "pet_details"
    const val VACCINE_CONTROL = "vaccine_control"
}

@Composable
fun Nav() {
    val navController = rememberNavController()

    val pets = listOf(
        Pet("AAAAAAA","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        Pet("BBBBBBB","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        Pet("CCCCCCC","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        Pet("DDDDDDD","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        Pet("EEEEEEE","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        Pet("FFFFFFF","dsajdhkasjhdkjahksa","26/04/2004","Perro")
    )

    val dummyPhotos = listOf(
        "https://placedog.net/500/400?id=1",
        "https://placedog.net/500/400?id=2",
        "https://placedog.net/500/400?id=3"
    )

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen(
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = { navController.navigate(Routes.MY_PETS) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }}
            )
        }

//        composable(Routes.REGISTER) {
//            RegisterScreen(
//                onRegisterSuccess = { navController.navigate(Routes.MY_PETS) {
//                    popUpTo(Routes.SPLASH) { inclusive = true }
//                }},
//                onBackClick = { navController.popBackStack() }
//            )
//        }

        composable(Routes.MY_PETS) {
            MyPetsScreen(
                pets,
                onPetClick = {
                    navController.navigate(Routes.PET_DETAILS)
                }
            )
        }

        composable(
            route = Routes.PET_DETAILS,
        ) { backStackEntry ->
            PetDetailScreen(
                "lola",
                "perrita juguetona",
                dummyPhotos,
                onBackClick = { navController.popBackStack() },
                onVaccineControlClick = {
                    navController.navigate(Routes.VACCINE_CONTROL)
                }
            )
        }

        composable(
            route = Routes.VACCINE_CONTROL,
        ) { backStackEntry ->
            VaccinesControlScreen(
                onBackClick = { navController.popBackStack() },
            )
        }

//        composable(
//            route = Routes.ADD_VACCINE,
//            arguments = listOf(navArgument("petId") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val petId = backStackEntry.arguments?.getString("petId") ?: ""
//            AddVaccineForm(
//                petId = petId,
//                onBackClick = { navController.popBackStack() },
//                onSaveSuccess = { navController.popBackStack() }
//            )
//        }
    }
}