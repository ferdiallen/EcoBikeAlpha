package com.tia.ecobike.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tia.ecobike.R
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.Greenify
import kotlinx.coroutines.delay

@Composable
fun SplashScreens(nav: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Greenify), contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.mainlogo),
            contentDescription = "main_logo",modifier = Modifier.size(210.dp,85.dp))
    }
    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        nav.navigate(NavigatorQueue.Login.route) {
            popUpTo(NavigatorQueue.SpalshScreen.route) {
                inclusive = true
            }
        }
    }
}
