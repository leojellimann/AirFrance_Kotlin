package com.shindra.aero.tptpsfip3a2022.ui.Data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

//Different types of states of the interface
sealed interface UiResponse<out T> {
    object Loading : UiResponse<Nothing>
    data class Error(val throwable: Throwable? = null) : UiResponse<Nothing>
    data class Success<T>(val data: T) : UiResponse<T>
}

//Fun should contain object of type T and one other of type UiResponse.Success
fun <T> Flow<T>.asUiState(): Flow<UiResponse<T>> {
    return this.map<T,UiResponse<T>> { UiResponse.Success(it) }.catch { emit( UiResponse.Error(it)) }
}