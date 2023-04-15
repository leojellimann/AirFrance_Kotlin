package com.shindra.aero.tptpsfip3a2022.ui

import AcafsxbDataSource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shindra.aero.tptpsfip3a2022.ui.Data.AcafsxbRepository
import com.shindra.aero.tptpsfip3a2022.ui.Data.PlanesInfos
import com.shindra.aero.tptpsfip3a2022.ui.Data.UiResponse
import com.shindra.aero.tptpsfip3a2022.ui.Data.asUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ClubPlaneViewModel : ViewModel() {
    private val acafsxbRepository = AcafsxbRepository(AcafsxbDataSource())
    val planeInfoUiResponse: StateFlow<UiResponse<List<PlanesInfos>>> =
        acafsxbRepository.planesInfo().asUiState().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiResponse.Loading
        )
}