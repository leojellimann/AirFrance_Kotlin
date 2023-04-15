package com.shindra.aero.tptpsfip3a2022.ui

import AcafsxbDataSource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindra.aero.tptpsfip3a2022.ui.Data.*
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn

class SpecificPlaneViewModel: ViewModel() {
    private val acafsxbRepository = AcafsxbRepository(AcafsxbDataSource())
    val specPlaneInfoUiResponse : StateFlow<UiResponse<List<SpecificPlanesInfos>>> =
        acafsxbRepository.specificPlanesInfo(Navigation.Specific.registration).asUiState().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiResponse.Loading
        )
    val planeTechnicalUIResponse : StateFlow<UiResponse<LimitPlanesInfos>> =
        acafsxbRepository.limitsPlanesInfo(Navigation.Specific.registration).asUiState().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiResponse.Loading
        )
}