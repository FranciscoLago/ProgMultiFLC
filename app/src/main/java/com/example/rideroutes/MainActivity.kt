// MainActivity.kt
package com.example.rideroutes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.rideroutes.ui.screens.*
import com.example.rideroutes.ui.theme.RideRoutesTheme

sealed class Screen(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Home : Screen("elemList", "Home", { Icon(Icons.Default.Home, null) })
    object Favorites : Screen("favList", "Favoritos", { Icon(Icons.Default.Favorite, null) })
    object Profile : Screen("profile", "Perfil", { Icon(Icons.Default.Person, null) })
    object About : Screen("about", "About", { Icon(Icons.Default.Info, null) })
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RideRoutesTheme {
                val navController = rememberNavController()
                val items = listOf(Screen.Home, Screen.Favorites, Screen.Profile, Screen.About)

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val backStack by navController.currentBackStackEntryAsState()
                            val current = backStack?.destination
                            items.forEach {
                                NavigationBarItem(
                                    icon = { it.icon() },
                                    label = { Text(it.label) },
                                    selected = current?.route == it.route,
                                    onClick = {
                                        navController.navigate(it.route) {
                                            popUpTo("elemList")
                                            launchSingleTop = true
                                        }
                                    }
                                )
                            }
                        }
                    }
                ) { padding ->
                    NavHost(
                        navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(padding)
                    ) {
                        composable(Screen.Home.route) { ElemListScreen(navController) }
                        composable("detailItem/{itemId}") {
                            DetailItemScreen(it.arguments?.getString("itemId"))
                        }
                        composable(Screen.Favorites.route) { FavListScreen(navController) }
                        composable("detailFav/{favId}") {
                            DetailFavScreen(it.arguments?.getString("favId"))
                        }
                        composable(Screen.Profile.route) { ProfileScreen() }
                        composable(Screen.About.route) { AboutScreen() }
                    }
                }
            }
        }
    }
}
