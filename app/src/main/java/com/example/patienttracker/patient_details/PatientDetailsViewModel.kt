package com.example.patienttracker.patient_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patienttracker.domain.model.Patient
import com.example.patienttracker.domain.model.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientDetailsViewModel @Inject constructor(
    private val repository: PatientRepository
) : ViewModel() {
    var state by mutableStateOf(PatientDetialsUiState())

    fun onAction(event: PatientDetailsEvents) {
        when(event) {
            is PatientDetailsEvents.EnteredName -> {
                state = state.copy(name = event.name)
            }
            is PatientDetailsEvents.EnteredAge -> {
                state = state.copy(age = event.age)
            }
            is PatientDetailsEvents.EnteredAssignedDoctor -> {
                state = state.copy(doctorAssigned = event.doctor)
            }
            is PatientDetailsEvents.EnteredPrescription -> {
                state = state.copy(prescription = event.prescription)
            }
            PatientDetailsEvents.SelectedFemale -> {
                state = state.copy(gender = 2)
            }
            PatientDetailsEvents.SelectedMale -> {
                state = state.copy(gender = 1)
            }
            PatientDetailsEvents.SaveButton -> {
                savePatient()
            }
        }

    }

//    fun onNameChange(newvalue: PatientDetailsEvents.EnteredName) {
//        state = state.copy(name = newvalue.toString())
//    }

    private fun savePatient() {
        viewModelScope.launch {
            repository.addOrUpdatePatient(
                patient = Patient(
                    name = state.name,
                    age = state.age,
                    gender = state.gender,
                    doctorAssigned = state.doctorAssigned,
                    prescription = state.prescription
                )
            )
        }
    }
}

