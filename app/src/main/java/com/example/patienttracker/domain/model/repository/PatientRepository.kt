package com.example.patienttracker.domain.model.repository

import com.example.patienttracker.domain.model.Patient

interface PatientRepository {
    suspend fun addOrUpdatePatient(patient: Patient)

    suspend fun deletePatient(patient: Patient)

    suspend fun getPatientByid(patientId: Int): Patient?

    fun getAllPatient(): kotlinx.coroutines.flow.Flow<List<Patient>>
}