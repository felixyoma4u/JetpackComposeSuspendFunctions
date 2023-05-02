package com.jetpackcompose.suspendfunctions.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LaunchedEffectNetworkStateViewModel: ViewModel() {

    private var _networkUnavailable = MutableStateFlow(false)
    val networkUnavailable get() = _networkUnavailable.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000L)
            _networkUnavailable.value = true
        }
    }

}