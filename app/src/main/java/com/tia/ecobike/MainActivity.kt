package com.tia.ecobike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tia.ecobike.navigation.LoginDisplays
import com.tia.ecobike.navigators.NavigatorQueue

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