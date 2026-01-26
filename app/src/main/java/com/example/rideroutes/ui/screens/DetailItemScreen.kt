// DetailItemScreen.kt
package com.example.rideroutes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailItemScreen(itemId: String?) {
    var isFav by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(itemId ?: "Elemento", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Text("Descripción detallada de la ruta seleccionada.")
        Spacer(Modifier.height(24.dp))
        Button(onClick = { isFav = !isFav }) {
            Icon(Icons.Default.Favorite, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(if (isFav) "Quitar de favoritos" else "Añadir a favoritos")
        }
    }
}
