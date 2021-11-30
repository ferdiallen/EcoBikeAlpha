package com.tia.ecobike.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreenHolder(
    val route: String,
    val title: String="def",
    val icon: ImageVector=Icons.Filled.Home
) {
    object Mains : BottomBarScreenHolder("home_screen", "Home", Icons.Filled.Home)
    object Cart : BottomBarScreenHolder("carts_fragment", "Cart", Icons.Filled.ShoppingCart)
    object Profile : BottomBarScreenHolder("profile_fragment", "Profile", Icons.Filled.Person)
    object SearchMenu: BottomBarScreenHolder("search_menu")
    object History: BottomBarScreenHolder("history_menu")
    object EditProfile : BottomBarScreenHolder("ediit_profile")
    object ScreenBikeCode: BottomBarScreenHolder("bike_screen")
    object IdentityFirst:BottomBarScreenHolder("first_identity")
    object IdentitySecond:BottomBarScreenHolder("second_identity")
}
