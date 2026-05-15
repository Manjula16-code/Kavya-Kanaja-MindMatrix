package com.example.kavyakanaja.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(

    primary = Color(0xFFFF9933),

    secondary = Color(0xFF1E3A8A),

    background = Color(0xFFFFF8E7),

    surface = Color(0xFFFFF8E7),

    onPrimary = Color.Black,

    onSecondary = Color.Black,

    onBackground = Color.Black,

    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(

    primary = Color(0xFFFFB74D),

    secondary = Color(0xFF90CAF9),

    background = Color(0xFF121212),

    surface = Color(0xFF1E1E1E),

    onPrimary = Color.White,

    onSecondary = Color.White,

    onBackground = Color.White,

    onSurface = Color.White
)

@Composable
fun KavyaKanajaTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(

        colorScheme = colors,

        typography = Typography(),

        content = content
    )
}