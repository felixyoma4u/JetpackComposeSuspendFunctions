package com.jetpackcompose.suspendfunctions.screens

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jetpackcompose.suspendfunctions.viewModels.LaunchedEffectNetworkStateViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LaunchedEffectNetworkState(
    snackbarHostState: SnackbarHostState,
    viewModel: LaunchedEffectNetworkStateViewModel
) {
    val showNetworkUnavailable by viewModel.networkUnavailable.collectAsState()
    if (showNetworkUnavailable) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar("Network Unavailable")
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Text(text = "Network State using LaunchedEffect")
    }
}