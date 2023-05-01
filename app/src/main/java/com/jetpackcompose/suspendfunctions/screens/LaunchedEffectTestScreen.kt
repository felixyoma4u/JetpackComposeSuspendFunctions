package com.jetpackcompose.suspendfunctions.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.jetpackcompose.suspendfunctions.viewModels.LaunchedEffectTestViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchedEffectTestScreen (
    snackbarHostState: SnackbarHostState,
    viewModel: LaunchedEffectTestViewModel
) {
    val snackbarCount =  viewModel.snackbarCount.collectAsState()
    LaunchedEffect(snackbarCount.value) {
        Log.d("launched-effect","displaying launched effect for count ${snackbarCount.value}")
        try {
            snackbarHostState.showSnackbar("LaunchedEffect snackbar", "ok")
        } catch(e: Exception){
            Log.d("launched-effect","launched Effect coroutine cancelled exception $e")
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column {
            Text(text = "LaunchedEffect Snackbar Test")
        }
    }

}