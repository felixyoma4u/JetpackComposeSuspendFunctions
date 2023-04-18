package com.jetpackcompose.suspendfunctions.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchedEffectTestScreen(
    snackbarHostState: SnackbarHostState
) {
    if (true) {
        LaunchedEffect(snackbarHostState) {
            snackbarHostState.showSnackbar("Snackbar", "ok")
        }
        
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column {
            Text(text = "test")
        }
    }


}