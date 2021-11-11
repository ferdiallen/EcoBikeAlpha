package com.tia.ecobike

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tia.ecobike.navigation.*
import com.tia.ecobike.navigators.NavigatorQueue
import com.tia.ecobike.ui.theme.EcoBikeTheme
import com.tia.ecobike.ui.theme.Greenify

@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController


    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoBikeTheme {
                navController = rememberAnimatedNavController()
                AdminController(nav = navController)
            }
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@OptIn(ExperimentalAnimationApi::class)
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
        NavigatorQueue.SpalshScreen.route -> {
            sysbarcolor.setStatusBarColor(Greenify)
        }
        NavigatorQueue.Forgot.route -> {
            sysbarcolor.setStatusBarColor(Color.Transparent, darkIcons = isDarkOrLight())
        }
        NavigatorQueue.ForgotPhase2.route -> {
            sysbarcolor.setStatusBarColor(Color.Transparent, darkIcons = isDarkOrLight())
        }
        NavigatorQueue.ForgotPhaseFinal.route -> {
            sysbarcolor.setStatusBarColor(Color.Transparent, darkIcons = isDarkOrLight())
        }
    }
    AnimatedNavHost(
        navController = nav,
        startDestination = NavigatorQueue.SpalshScreen.route
    ) {
        composable(route = NavigatorQueue.Main.route) {
            MainDisplays()
        }
        composable(route = NavigatorQueue.Login.route,
            enterTransition = {
                when (this.initialState.destination.route) {
                    NavigatorQueue.ForgotPhaseFinal.route -> {
                        fadeIn(tween(300))
                    }
                    else -> slideInHorizontally(initialOffsetX = { 800 })
                }

            },
            exitTransition = {
                fadeOut(tween(300))
            },
            popEnterTransition = {
                fadeIn(tween(500))
            }
        ) {
            LoginDisplays(navcon = nav)
        }
        composable(route = NavigatorQueue.Forgot.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 800 })
            },
            exitTransition = {
                when (this.targetState.destination.route) {
                    NavigatorQueue.Login.route -> {
                        slideOutHorizontally(targetOffsetX = { 500 })
                    }
                    else -> fadeOut(tween(300))
                }
            },
            popEnterTransition = {
                fadeIn(tween(500))
            }
        ) {
            ForgotDisplay(nav = nav)
        }
        composable(
            route = NavigatorQueue.ForgotPhase2.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 800 })
            },
            exitTransition = {
                when (this.targetState.destination.route) {
                    NavigatorQueue.Forgot.route -> {
                        slideOutHorizontally(targetOffsetX = { 500 })
                    }
                    else -> fadeOut(tween(300))
                }
            },
            popEnterTransition = {
                fadeIn(tween(500))
            }
        ) {
            ForgotDisplayPhase2(nav = nav)
        }
        composable(
            route = NavigatorQueue.ForgotPhaseFinal.route,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { 800 })
            },
            exitTransition = {
                when (this.targetState.destination.route) {
                    NavigatorQueue.ForgotPhase2.route -> {
                        slideOutHorizontally(targetOffsetX = { 500 })
                    }
                    else -> slideOutVertically(targetOffsetY = { 800 })
                }
            }
        ) {
            ForgotDisplayFinalPhase(nav = nav)
        }
        composable(
            route = NavigatorQueue.SpalshScreen.route,
            exitTransition = {
                fadeOut(tween(350))
            }
        ) {
            SplashScreens(nav)
        }
    }
}