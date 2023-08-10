package com.example.patienttracker.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.patienttracker.patient_details.PatientDetailsViewModel
import com.example.patienttracker.patient_list.PatientListScreen
import com.example.patienttracker.presentation.patient_details.PatientDetailsScreen
import com.example.patienttracker.util.Constants.PATIENT_DETAILS_ARG_KEY

sealed class Screen(val route: String) {
    object PatientList: Screen("patient_list_screen")
    object PatientDetails: Screen("patient_details_screen?$PATIENT_DETAILS_ARG_KEY={$PATIENT_DETAILS_ARG_KEY}") {
        fun passPatientId(patientId: Int? = null): String{
            return "patient_details_screen?patientId=$PATIENT_DETAILS_ARG_KEY"
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraphSetup(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PatientList.route
    ) {
        composable(
            route = Screen.PatientList.route
        ) {
            PatientListScreen(
                onFabClicked = {
                    navController.navigate(Screen.PatientDetails.route)
                },
                onItemClicked = {
                    navController.navigate(Screen.PatientDetails.passPatientId(it))
                }
            )
        }
        composable(
            route = Screen.PatientDetails.route,
            arguments = listOf(navArgument(name = PATIENT_DETAILS_ARG_KEY) {
                type = NavType.IntType
                defaultValue = 1 }
            )
        ) {
            val viewModel = viewModel<PatientDetailsViewModel>()
            PatientDetailsScreen(
                viewModel = viewModel,
                onBackClick = { navController.navigateUp() }
            )
        }
    }
}