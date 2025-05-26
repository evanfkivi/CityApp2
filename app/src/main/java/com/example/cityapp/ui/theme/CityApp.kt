package com.example.cityapp.ui.theme

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.cityapp.data.List
import com.example.cityapp.model.CityItem
import com.example.cityapp.model.Routes

@Composable
fun CityApp (
    viewModel: CityViewModel = viewModel()
) {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination
    val viewModel: CityViewModel = viewModel()

    Scaffold(
    ) {innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Routes.Start.route
            )
        {
            composable(route = Routes.Start.route) {
                CityHomeScreen(List = List.filter{it.type == "category"},
                    onCoffeeClicked = {navController.navigate(Routes.Coffee.route)},
                    onRestaurantsClicked = {navController.navigate(Routes.Restaurants.route)},
                    onParksClicked = {navController.navigate(Routes.Parks.route)})
            }

            composable(route = Routes.Coffee.route) {
                CityRecScreen(List = List.filter{it.type == "coffeeShop"},
                    navController = navController)
            }

            composable(route = Routes.Restaurants.route) {
                CityRecScreen(List = List.filter{it.type == "restaurant"},
                    navController = navController)
            }

            composable(route = Routes.Parks.route) {
                CityRecScreen(List = List.filter{it.type == "park"},
                    navController = navController)
            }

            composable(route = Routes.Recommendations.route) {
                val cityItem = it.arguments?.getString("cityItem")
                CityDescriptionScreen(cityItem = cityItem)
            }
        }
    }
}