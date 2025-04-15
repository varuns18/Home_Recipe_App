package com.ramphal.homerecipe



sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "HomeScreen")
    object RecipeDetails: Screen(route = "recipeDetails/{id}")
}