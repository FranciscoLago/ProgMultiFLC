// DetailFavScreen.kt
package com.example.rideroutes.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailFavScreen(favId: String?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(favId ?: "Favorito", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(3) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        "Comentario del usuario ${it + 1}",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
