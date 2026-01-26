// ProfileScreen.kt
package com.example.rideroutes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    var logged by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Perfil de Usuario", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text(if (logged) "Sesión iniciada" else "Sesión cerrada")
        Spacer(Modifier.height(24.dp))
        Button(onClick = { logged = !logged }) {
            Text(if (logged) "Logout" else "Login")
        }
    }
}
