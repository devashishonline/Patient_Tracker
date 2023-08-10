package com.example.patienttracker.patient_details

data class PatientDetialsUiState(
    val name: String = "",
    val age: String = "",
    val gender: Int = 0,
    val doctorAssigned: String = "",
    val prescription: String = ""

)