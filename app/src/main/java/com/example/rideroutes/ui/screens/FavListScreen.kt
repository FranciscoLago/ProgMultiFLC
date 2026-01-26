// FavListScreen.kt
package com.example.rideroutes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FavListScreen(navController: NavController) {
    val favorites = remember { mutableStateListOf("Ruta Sierra Norte", "Ruta Costa") }
    var toDelete by remember { mutableStateOf<String?>(null) }

    if (toDelete != null) {
        AlertDialog(
            onDismissRequest = { toDelete = null },
            confirmButton = {
                TextButton(onClick = {
                    favorites.remove(toDelete)
                    toDelete = null
                }) { Text("Aceptar") }
            },
            dismissButton = {
                TextButton(onClick = { toDelete = null }) { Text("Cancelar") }
            },
            title = { Text("Eliminar favorito") },
            text = { Text("¿Seguro que deseas eliminar este favorito?") }
        )
    }

    LazyColumn {
        items(favorites) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detailFav/$item") }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item)
                    IconButton(onClick = { toDelete = item }) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                    }
                }
            }
        }
    }
}
