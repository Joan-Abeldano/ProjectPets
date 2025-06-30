package com.example.projectpets.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectpets.models.PetData
import com.example.projectpets.ui.screens.LoginScreen
import com.example.projectpets.ui.screens.MyPetsScreen
import com.example.projectpets.ui.screens.PetDetailScreen
import com.example.projectpets.ui.screens.SplashScreen
import com.example.projectpets.ui.screens.VaccinesControlScreen
import com.example.projectpets.ui.screens.FormReminderScreen
import com.example.projectpets.ui.screens.ReminderListScreen
import com.example.projectpets.models.Reminder
import com.example.projectpets.ui.screens.AddPetScreen
import com.example.projectpets.ui.screens.AddVaccineForm

object Routes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val MY_PETS = "my_pets"
    const val PET_DETAILS = "pet_details"
    const val VACCINE_CONTROL = "vaccine_control"
    const val FORM_REMINDER = "form_reminder"
    const val LIST_REMINDERS = "list_reminders"
    const val ADD_PET = "add_pet"
    const val ADD_VACCINE = "add_vaccine"
}

@Composable
fun Nav() {
    val navController = rememberNavController()

    val petData = listOf(
        PetData("AAAAAAA","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        PetData("BBBBBBB","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        PetData("CCCCCCC","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        PetData("DDDDDDD","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        PetData("EEEEEEE","dsajdhkasjhdkjahksa","26/04/2004","Perro"),
        PetData("FFFFFFF","dsajdhkasjhdkjahksa","26/04/2004","Perro")
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

        //Composables to ReminderScreens
        composable(Routes.FORM_REMINDER) {
            FormReminderScreen(
                onBackClick = { navController.popBackStack() },
                onSaveReminder = { navController.popBackStack() }
            )
        }

        composable(Routes.LIST_REMINDERS) {
            // Lista dummy para probar la pantalla
            val sampleReminders = listOf(
                Reminder(date = "23/06/2024", time = "11:00 a.m"),
                Reminder(date = "29/02/2024", time = "9:00 a.m"),
                Reminder(date = "20/06/2024", time = "10:00 a.m"),
                Reminder(date = "07/12/2024", time = "2:00 p.m")
            )

            ReminderListScreen(
                reminders = sampleReminders,
                onDelete = {},
                onBackClick = { navController.popBackStack() },
                onAddReminderClick = {
                    navController.navigate(Routes.FORM_REMINDER)
                }
            )
        }


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
                onPetClick = {
                    navController.navigate(Routes.PET_DETAILS)
                },
                onAddPetClick = {
                    navController.navigate(Routes.ADD_PET)
                }
            )
        }
        composable(Routes.ADD_PET) {
            AddPetScreen(onBackClick = { navController.popBackStack() })
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
                },
                onReminderClick = {
                    navController.navigate(Routes.LIST_REMINDERS)
                }
            )
        }

        composable(
            route = Routes.VACCINE_CONTROL,
        ) { backStackEntry ->
            VaccinesControlScreen(
                onBackClick = { navController.popBackStack() },
                onAddVaccineClick = {
                    navController.navigate(Routes.ADD_VACCINE)
                }
            )
        }

        composable(
            route = Routes.ADD_VACCINE,
        ) { backStackEntry ->
            AddVaccineForm(
                onBackClick = { navController.popBackStack() },
                onGuardarClick = { name, date, desc, admin, tachar ->
                    // Handle saving the vaccine here
                    navController.popBackStack()
                }
            )
        }
    }
}