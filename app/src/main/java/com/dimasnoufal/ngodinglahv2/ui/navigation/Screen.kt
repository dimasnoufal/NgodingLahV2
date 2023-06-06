package com.dimasnoufal.ngodinglahv2.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Profile : Screen("profile_screen")
    object DetailBahasa : Screen("home_screen/{bahasaId}") {
        fun createRoute(bahasaId: Long) = "home_screen/$bahasaId"
    }
}