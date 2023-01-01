package com.example.coba2

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController) {
    Column {
        Text(text = "Ini dari Page 2")
        Button(onClick = {
            navController.navigate(Screen.MainScreen.route) {
                popUpTo(Screen.MainScreen.route) {
                    inclusive = true
                }
            }
        }) {
            Text("Kembali")
        }
    }
}