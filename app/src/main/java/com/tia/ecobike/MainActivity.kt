package com.tia.ecobike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tia.ecobike.navigation.LoginDisplays
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.Greenify

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            AdminController(nav = navController)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun AdminController(nav: NavHostController) {
    val sysbarcolor = rememberSystemUiController()
    SideEffect {
        sysbarcolor.setStatusBarColor(color = Greenify)
    }
    NavHost(
        navController = nav,
        startDestination = NavigatorQueue.Login.route
    ) {
        composable(route = NavigatorQueue.Main.route) {

        }
        composable(route = NavigatorQueue.Login.route) {
            LoginDisplays()
        }
        composable(route = NavigatorQueue.Register.route) {

        }
    }
}