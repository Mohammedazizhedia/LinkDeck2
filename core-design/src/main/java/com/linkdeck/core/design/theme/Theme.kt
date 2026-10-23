package com.linkdeck.core.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val LightBackground = Color(0xFFF8F7F3)
val LightSurface = Color(0xFFFDFDFB)
val LightSurfaceVariant = Color(0xFFEFEDE6)
val LightOnSurface = Color(0xFF1B1C1A)
val LightOnSurfaceVariant = Color(0xFF44463F)
val LightOutline = Color(0xFF75776C)

val DarkBackground = Color(0xFF0F100E)
val DarkSurface = Color(0xFF131412)
val DarkSurfaceVariant = Color(0xFF2C2C2A)
val DarkOnSurface = Color(0xFFE4E3DD)
val DarkOnSurfaceVariant = Color(0xFFC6C7BF)
val DarkOutline = Color(0xFF8F9186)

enum class AccentTheme { DEFAULT, TEAL, INDIGO, AMBER, ROSE, DYNAMIC }
enum class AppThemeMode { SYSTEM, LIGHT, DARK }

@Composable
fun LinkDeckTheme(
    themeMode: AppThemeMode = AppThemeMode.SYSTEM,
    accent: AccentTheme = AccentTheme.DEFAULT,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeMode) {
        AppThemeMode.SYSTEM -> isSystemInDarkTheme()
        AppThemeMode.LIGHT -> false
        AppThemeMode.DARK -> true
    }

    val context = LocalContext.current
    val colorScheme = when {
        accent == AccentTheme.DYNAMIC && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        else -> getAccentColorScheme(accent, darkTheme)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

fun getAccentColorScheme(accent: AccentTheme, isDark: Boolean): ColorScheme {
    return if (isDark) {
        darkColorScheme(
            primary = Color(0xFFB5D4F4), onPrimary = Color(0xFF0C2C4E),
            primaryContainer = Color(0xFF14395C), onPrimaryContainer = Color(0xFFCFE3F8),
            background = DarkBackground, surface = DarkSurface, surfaceVariant = DarkSurfaceVariant
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF185FA5), onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFD6E7F9), onPrimaryContainer = Color(0xFF0B3E6F),
            background = LightBackground, surface = LightSurface, surfaceVariant = LightSurfaceVariant
        )
    }
}
