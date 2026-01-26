// AboutActivity.kt
package com.example.rideroutes.ui.about

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.rideroutes.ui.screens.AboutScreen

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            AboutScreen()
        }
    }

    fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("franciscolagocervera@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, "Información sobre RideRoutes")
            putExtra(Intent.EXTRA_TEXT, "Hola,\n\nQuisiera recibir información sobre RideRoutes 🏍️.\n\nUn saludo.")
        }
        startActivity(Intent.createChooser(emailIntent, "Enviar correo con…"))
    }
}
