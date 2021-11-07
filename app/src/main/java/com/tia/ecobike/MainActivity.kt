package com.tia.ecobike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tia.ecobike.navigation.ForgotDisplay
import com.tia.ecobike.navigation.LoginDisplays
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.EcoBikeTheme
import com.tia.ecobike.ui.theme.Greenify

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoBikeTheme {
                navController = rememberNavController()
                AdminController(nav = navController)
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AdminController(nav: NavHostController) {
    val sysbarcolor = rememberSystemUiController()
    val currentstack by nav.currentBackStackEntryAsState()
    val uiState = isSystemInDarkTheme()
    fun isDarkOrLight(): Boolean {
        return when (uiState) {
            true -> {
                false
            }
            false -> {
                true
            }
        }
    }
    when (currentstack?.destination?.route) {
        NavigatorQueue.Login.route -> {
            sysbarcolor.setStatusBarColor(Greenify)
        }
        NavigatorQueue.Forgot.route -> {
            sysbarcolor.setStatusBarColor(Color.Transparent, darkIcons = isDarkOrLight())
        }
    }
    NavHost(
        navController = nav,
        startDestination = NavigatorQueue.Login.route
    ) {
        composable(route = NavigatorQueue.Main.route) {

        }
        composable(route = NavigatorQueue.Login.route) {
            LoginDisplays(navcon = nav)
        }
        composable(route = NavigatorQueue.Forgot.route) {
            ForgotDisplay(nav)
        }
    }
}