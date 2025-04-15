package com.ramphal.homerecipe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ramphal.homerecipe.viewmodels.DetailViewModel
import com.ramphal.homerecipe.viewmodels.MainViewModel

@Composable
fun RecipeApp(modifier: Modifier = Modifier, navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val homeViewState by recipeViewModel.mealsListState

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(
                modifier = modifier,
                viewState = homeViewState,
                navigatingToRecipeDetails = { id ->
                    navController.navigate("${Screen.RecipeDetails.route}/$id")
                }
            )
        }
        composable(
            route = "${Screen.RecipeDetails.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            val detailViewModel: DetailViewModel = viewModel()
            val detailViewState by detailViewModel.recipeDitailState

            RecipeDetails(
                modifier = modifier,
                viewState = detailViewState,
                navigatingToHomeScreen = {
                    navController.navigate(Screen.HomeScreen.route)
                }
            )
        }
    }
}
