package com.ramphal.homerecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.ramphal.homerecipe.data.ListOfMeals
import com.ramphal.homerecipe.viewmodels.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigatingToRecipeDetails:(String) -> Unit,
    viewState: MainViewModel.RecipeState
){

    Box(modifier = modifier.fillMaxSize()){
        when{
            viewState.loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            viewState.error != null -> {
                Text(text = "error")
            }
            else -> {
                CategoryScreen(meals = viewState.list, navigatingToRecipeDetails = navigatingToRecipeDetails)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(meals: List<ListOfMeals>, navigatingToRecipeDetails:(String) -> Unit){
    val lezyState = rememberLazyGridState()
    LazyVerticalGrid (columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize(), state = lezyState) {
        items (meals, key = {
            it.idMeal
        }) {
            CategoryItem(meals = it, navigatingToRecipeDetails = navigatingToRecipeDetails)
        }
    }
}

@Composable
fun CategoryItem(meals: ListOfMeals, navigatingToRecipeDetails:(String) -> Unit){
    Box(
        modifier = Modifier.padding(10.dp)
    ) {
        ImageCard(
            id = meals.idMeal,
            title = meals.strMeal,
            painter = rememberAsyncImagePainter(meals.strMealThumb),
            navigatingToRecipeDetails = navigatingToRecipeDetails
        )
    }
}

@Composable
fun ImageCard(
    id: String,
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier,
    navigatingToRecipeDetails:(String) -> Unit
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth().clickable{
            navigatingToRecipeDetails(id)
        },
        shape = RoundedCornerShape(16.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize().padding(6.dp)) {

            Card(shape = RoundedCornerShape(15.dp)) {
                Image(
                    painter = painter,
                    contentDescription = "Image of $title",
                    Modifier.fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier.fillMaxSize()
                    .padding(top = 136.dp, start = 6.dp, end = 6.dp)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = title, style = MaterialTheme.typography.bodySmall)
            }
        }

    }
}


@Composable
fun ImageCardHorizontal(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row (modifier = Modifier.fillMaxSize().padding(6.dp)) {

            Card(shape = RoundedCornerShape(15.dp)) {
                Image(
                    painter = painter,
                    contentDescription = "Image of $title",
                    Modifier.fillMaxWidth(0.36f)
                        .height(130.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column (
                modifier = Modifier.padding(start = 12.dp, top = 6.dp, end = 6.dp, bottom = 6.dp)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = title, style = MaterialTheme.typography.bodySmall)
            }
            Column(
                modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.requiredSize(20.dp)
                    )
                }
            }
        }

    }
}
