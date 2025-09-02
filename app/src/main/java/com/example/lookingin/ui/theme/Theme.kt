package com.example.lookingin.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CreaLierreDarkGreen, // Or a darker variant for dark theme
    secondary = CreaLierreLightGreen, // Or a different accent for dark theme
    tertiary = Pink80, // Placeholder, can be another CreaLierre accent
    background = Color.Black, // Example dark background
    surface = Color(0xFF1C1B1F), // Example dark surface
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = CreaLierreDarkGreen,
    secondary = CreaLierreLightGreen,
    tertiary = CreaLierreBeige, // Using Beige as a tertiary/accent
    background = CreaLierreBeige, // Beige as the main background
    surface = Color.White, // White for surfaces like cards, sheets
    onPrimary = Color.White, // Text/icons on Dark Green
    onSecondary = Color.Black, // Text/icons on Light Green
    onTertiary = CreaLierreDarkGreen, // Text/icons on Beige
    onBackground = CreaLierreDarkGreen, // Text/icons on Beige Background
    onSurface = Color.Black // Text/icons on White Surface
)

@Composable
fun LookingInTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Set to false to use custom theme
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}