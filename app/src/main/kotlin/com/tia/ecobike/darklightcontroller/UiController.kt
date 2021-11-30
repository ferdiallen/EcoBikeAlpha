package com.tia.ecobike.darklightcontroller

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

object UiController {
    @Composable
    fun setUi(): SystemUiController {
        return rememberSystemUiController()
    }
}