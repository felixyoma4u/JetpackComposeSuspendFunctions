package com.jetpackcompose.suspendfunctions.viewModels.launched.effect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LaunchedEffectTestViewModel : ViewModel() {

    private var _snackbarCount = MutableStateFlow(1)
    val snackbarCount: StateFlow<Int> get() = _snackbarCount

    init {
        viewModelScope.launch {
            var displayCount = 1
            while (displayCount < 3) {
                delay(1000L)
                displayCount += 1
                _snackbarCount.value = displayCount
            }
        }
    }
}