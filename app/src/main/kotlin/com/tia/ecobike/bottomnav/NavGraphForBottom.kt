package com.tia.ecobike.bottomnav

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tia.ecobike.navigation.CartDisplayScreen
import com.tia.ecobike.navigation.HomeScreens
import com.tia.ecobike.navigation.ProfileScreens

@ExperimentalMaterialApi
@Composable
fun NavGraphScaffoldBottom(nav: NavHostController,mainNav:NavHostController) {
    NavHost(
        navController = nav,
        startDestination = BottomBarScreenHolder.Mains.route
    ) {
        composable(route = BottomBarScreenHolder.Mains.route){
            HomeScreens(mainNav)
        }
        composable(route = BottomBarScreenHolder.Cart.route){
            CartDisplayScreen(nav)
        }
        composable(route = BottomBarScreenHolder.Profile.route){
           ProfileScreens()
        }
    }
}