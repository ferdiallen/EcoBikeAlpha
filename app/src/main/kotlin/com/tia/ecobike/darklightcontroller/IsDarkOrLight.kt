package com.tia.ecobike.darklightcontroller

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object IsDarkOrLight {
    @Composable
    fun isDarkOrLight(): Color {
        val isDark = isSystemInDarkTheme()
        return when (isDark) {
            true -> {
                Color.White
            }
            false -> {
                Color.Black
            }
        }
    }
}