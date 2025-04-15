package com.ramphal.homerecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ramphal.homerecipe.ui.theme.HomeRecipeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            HomeRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeApp(modifier = Modifier.padding(innerPadding), navController = navController)
                }
            }
        }
    }
}


@Composable
fun cardViewImage(modifier: Modifier){
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row (modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)) {

            Card(shape = RoundedCornerShape(15.dp)) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "Image of ",
                    Modifier
                        .fillMaxWidth(0.3f)
                        .height(130.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 136.dp, top = 6.dp, end = 6.dp, bottom = 6.dp)
            ) {
                Text(text = "title", style = MaterialTheme.typography.titleMedium)
                Text(text = "title", style = MaterialTheme.typography.bodySmall)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeRecipeAppPreview() {
    HomeRecipeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            cardViewImage(modifier = Modifier.padding(innerPadding))
        }
    }
}






