package com.tia.ecobike.navigators

sealed class NavigatorQueue(val route: String) {
    object Login : NavigatorQueue("main_login")
    object Register : NavigatorQueue("register_page")
    object Main : NavigatorQueue("dashboard")
    object Forgot : NavigatorQueue("forgot_pw")
}
