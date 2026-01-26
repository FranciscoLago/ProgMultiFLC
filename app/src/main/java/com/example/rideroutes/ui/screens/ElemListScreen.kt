// ElementListScreen.kt
package com.example.rideroutes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElemListScreen(navController: NavController) {
    var search by remember { mutableStateOf("") }
    val elements = remember {
        listOf(
            "Ruta Sierra Norte",
            "Ruta Costa",
            "Ruta Interior",
            "Ruta Nocturna",
            "Ruta Montaña"
        )
    }
    val favorites = remember { mutableStateListOf<String>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = search,
                        onValueChange = { search = it },
                        placeholder = { Text("Buscar...") }
                    )
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(elements.filter {
                it.contains(search, ignoreCase = true)
            }) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate("detailItem/$item") }
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item)
                        IconButton(onClick = {
                            if (favorites.contains(item)) favorites.remove(item)
                            else favorites.add(item)
                        }) {
                            Icon(
                                if (favorites.contains(item)) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}
