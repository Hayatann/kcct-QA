package com.example.chatapplication.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.google.accompanist.navigation.animation.composable
import com.example.chatapplication.ui.theme.ChatApplicationTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChatApp(
    viewModel: SharedViewModel = viewModel()
) {
    val navController = rememberAnimatedNavController()
    ChatApplicationTheme {
        AnimatedNavHost(

            navController = navController,
            startDestination = Destination.GroupList.route,
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            enterTransition = {
                slideIn { fullSize -> IntOffset(fullSize.width, 0) }
            },
            popEnterTransition = {
                slideIn { fullSize -> IntOffset(-fullSize.width, 0) }
            },
            exitTransition = {
                slideOut { fullSize -> IntOffset(-fullSize.width, 0) }
            },
            popExitTransition = {
                slideOut { fullSize -> IntOffset(fullSize.width, 0) }
            },
        ) {
            composable(route = Destination.GroupList.route) {
                GroupScreen(
                    onGroupClick = {
                        navController.navigate(Destination.Chat.route)
                    },
                    viewModel = viewModel
                )
            }
            composable(route = Destination.Chat.route) {
                ChatScreen(
                    onBackClick = { navController.popBackStack() },
                    viewModel = viewModel
                )
            }
        }
    }
}
