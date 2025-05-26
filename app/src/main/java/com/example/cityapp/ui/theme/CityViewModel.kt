package com.example.cityapp.ui.theme

import androidx.lifecycle.ViewModel
import com.example.cityapp.model.CityUiState
import com.example.cityapp.model.CityItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CityUiState())
    val uiState: StateFlow<CityUiState> = _uiState.asStateFlow()

}

