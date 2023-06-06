package com.dimasnoufal.ngodinglahv2

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dimasnoufal.ngodinglahv2.ui.navigation.NavigationItem
import com.dimasnoufal.ngodinglahv2.ui.navigation.Screen
import com.dimasnoufal.ngodinglahv2.ui.screen.detail.DetailScreen
import com.dimasnoufal.ngodinglahv2.ui.screen.home.HomeScreen
import com.dimasnoufal.ngodinglahv2.ui.screen.profile.ProfileScreen
import com.dimasnoufal.ngodinglahv2.ui.theme.NgodingLahV2Theme

@Composable
fun NgodingLahV2App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailBahasa.route) {
                BottomBar(navController, currentRoute)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { bahasaid ->
                        navController.navigate(Screen.DetailBahasa.createRoute(bahasaid))
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(
                route = Screen.DetailBahasa.route,
                arguments = listOf(navArgument("bahasaId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("bahasaId") ?: -1L
                DetailScreen(
                    bahasaId = id,
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    currentRoute: String?,
    modifier: Modifier = Modifier,
) {
    BottomNavigation(
        modifier = modifier,
    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home,
                contetDescription = stringResource(R.string.content_description_menu_home)
            ),
            NavigationItem(
                title = stringResource(R.string.profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile,
                contetDescription = stringResource(R.string.content_description_profile)
            ),
        )
        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.contetDescription,
                            )
                    },
                    label = { Text(item.title) },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NgodingLahV2AppPreview() {
    NgodingLahV2Theme {
        NgodingLahV2App()
    }
}