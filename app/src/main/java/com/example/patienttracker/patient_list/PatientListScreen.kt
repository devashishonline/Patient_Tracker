package com.example.patienttracker.patient_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.patienttracker.domain.model.Patient

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun PatientListScreen(
    onFabClicked: () -> Unit,
    onItemClicked: (Int?) ->Unit,
    viewModel: PatientListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val patientList = listOf(
        // Patients list goes here
        Patient(
            name = "Mohammad Ali",
            age = 25.toString(),
            gender = 1,
            doctorAssigned = "Dr. Drake",
            prescription = "Keep drinking water"
        ),
        Patient(
            name = "Rachel Green",
            age = 21.toString(),
            gender = 2,
            doctorAssigned = "Dr. Rossie",
            prescription = "Don't drink water"
        )
    )

    Scaffold(
        topBar = { ListAppBar() },
        floatingActionButton = {
            ListFab(onFabClicked = onFabClicked)
        },
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        Column {
            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
            )

            if (patientList.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add Patients Details\nby pressing the add button.",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                Spacer(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                )
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),

                ) {
                    items(patientList) { patient ->
                        PatientItem(
                            patient = patient,
                            onItemClicked = { onItemClicked(patient.patientId) },
                            onDeleteConfirm = {}
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Patient Tracker",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),

                )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
            )
        }
    )
}


@Composable
fun ListFab(
    onFabClicked: () -> Unit
) {
    FloatingActionButton(onClick = onFabClicked) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Patient Button"
        )
    }

}
/*
Patient(
name = "Mohammad Ali",
age = 25,
gender = "male",
doctorAssigned = "Dr. Drake",
prescription = "Keep drinking water"
),
Patient(
name = "Rachel Green",
age = 21,
gender = "female",
doctorAssigned = "Dr. Rossie",
prescription = "Don't drink water"
)
*/
