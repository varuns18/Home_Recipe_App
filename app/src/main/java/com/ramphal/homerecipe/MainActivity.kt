package com.ramphal.homerecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ramphal.homerecipe.navigation.RecipeApp
import com.ramphal.homerecipe.ui.theme.HomeRecipeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HomeRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeApp(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeRecipeAppPreview() {
    HomeRecipeTheme {
        val navController = rememberNavController()
        3
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            RecipeApp(
                modifier = Modifier.padding(innerPadding),
                navController = navController
            )
        }
    }
}






