package com.tia.ecobike.bottomnav

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.tia.ecobike.navigation.*
import com.tia.ecobike.navigation.searchfragment.SearchScreenBike

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun NavGraphScaffoldBottom(nav: NavHostController, mainNav: NavHostController) {
    NavHost(
        navController = nav,
        startDestination = BottomBarScreenHolder.Mains.route
    ) {
        composable(route = BottomBarScreenHolder.Mains.route) {
            HomeScreens(nav)
        }
        composable(route = BottomBarScreenHolder.Cart.route) {
            CartDisplayScreen(nav)
        }
        composable(route = BottomBarScreenHolder.Profile.route) {
            ProfileScreens(mainNav, nav)
        }
        composable(route = BottomBarScreenHolder.SearchMenu.route) {
            SearchScreenBike(nav = nav)
        }
        composable(route = BottomBarScreenHolder.History.route) {
            HistoryDisplay(nav)
        }
        composable(route = BottomBarScreenHolder.EditProfile.route) {
            EditDisplay(nav)
        }
        composable(route = BottomBarScreenHolder.ScreenBikeCode.route) {
            BikeCode()
        }
        composable(route = BottomBarScreenHolder.IdentityFirst.route) {
            IdentityDisplayFirst(nav)
        }
        composable(route = BottomBarScreenHolder.IdentitySecond.route) {
            IdentitySecondDisplay(nav)
        }
    }
}