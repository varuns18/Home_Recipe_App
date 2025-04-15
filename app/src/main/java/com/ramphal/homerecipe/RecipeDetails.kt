package com.ramphal.homerecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ramphal.homerecipe.data.RecipeDetails
import com.ramphal.homerecipe.viewmodels.DetailViewModel

@Composable
fun RecipeDetails(modifier: Modifier = Modifier,viewState: DetailViewModel.RecipeDetailState, navigatingToHomeScreen:() -> Unit){

    Box(modifier = modifier.fillMaxSize()){
        when{
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "error")
            }
            else -> {
                DisplayMealDetails(meals = viewState.list, navigatingToHomeScreen = navigatingToHomeScreen)
            }
        }
    }

}

@Composable
fun DisplayMealDetails(meals: List<RecipeDetails>, navigatingToHomeScreen: () -> Unit) {
    val scrollState = rememberScrollState()
    val display = meals.getOrNull(0)

    if (display != null) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(display.strMealThumb),
                contentDescription = display.strMeal,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
            )

            // 2. Use a Column (or Box) to place components on top of the image
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Row at the very top, overlapping the image
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Back icon
                    FilledTonalIconButton (onClick = {}, shape = RoundedCornerShape(10.dp)){
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                    }
                    // Favorite icon
                    FilledTonalIconButton (onClick = {}, shape = RoundedCornerShape(10.dp)){
                        Icon(imageVector = Icons.Rounded.Favorite, contentDescription = null)
                    }
                }

                Spacer(modifier = Modifier.height(200.dp))
                Card (
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))

                ) {
                    // Title row
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    ) {
                        Text(
                            text = display.strMeal,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = display.strInstructions,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    // ... add the rest of your content here ...
                }
            }
        }

    } else {
        // Handle the case where the desired meal is not available
        Text(text = "Meal details are not available.")
    }
}


