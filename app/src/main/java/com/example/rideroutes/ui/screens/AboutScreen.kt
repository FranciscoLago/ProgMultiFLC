// AboutScreen.kt
package com.example.rideroutes.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.rideroutes.R

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray,
        contentColor = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.mi_icono),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(stringResource(R.string.about_title), style = MaterialTheme.typography.headlineLarge)
            Spacer(Modifier.height(8.dp))
            Text(stringResource(R.string.about_theme), style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            Text(
                stringResource(R.string.about_description),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Text("Versión: 1.0")
            Spacer(Modifier.height(24.dp))
            Button(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("franciscolagocervera@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "Información sobre RideRoutes")
                    putExtra(Intent.EXTRA_TEXT, "Hola,\n\nQuisiera recibir información sobre RideRoutes 🏍️.\n\nUn saludo.")
                }
                context.startActivity(Intent.createChooser(intent, "Enviar correo con…"))
            }) {
                Icon(Icons.Default.Email, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Contactar")
            }
        }
    }
}
