package com.tia.ecobike.navigators

sealed class NavigatorQueue(val route: String) {
    object Login : NavigatorQueue("main_login")
    object Register : NavigatorQueue("register_page")
    object Main : NavigatorQueue("dashboard")
    object Forgot : NavigatorQueue("forgot_pw")
    object ForgotPhase2:NavigatorQueue("forgot_pw_2")
    object ForgotPhaseFinal:NavigatorQueue("forgot_pw_3")
    object SpalshScreen:NavigatorQueue("splash_screen")
}
