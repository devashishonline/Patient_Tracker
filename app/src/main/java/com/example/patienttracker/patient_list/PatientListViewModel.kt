package com.example.patienttracker.patient_list

import androidx.lifecycle.ViewModel
import com.example.patienttracker.domain.model.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PatientListViewModel @Inject constructor(
    private val repository: PatientRepository
): ViewModel() {
}