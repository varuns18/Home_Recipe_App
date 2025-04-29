package com.ramphal.homerecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramphal.homerecipe.model.HomeMeal
import com.ramphal.homerecipe.model.homeMealsList
import com.ramphal.homerecipe.ui.theme.HomeRecipeTheme
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

@Composable
fun CategoryScreen(
    meals: List<HomeMeal>,
    navigatingToRecipeDetails: (String) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(
            items = meals,
            key = { it.id }
        ) { meal ->
            CategoryItem(
                meals = meal,
                navigatingToRecipeDetails = navigatingToRecipeDetails
            )
        }
    }
}



@Composable
fun CategoryItem(meals: HomeMeal, navigatingToRecipeDetails:(String) -> Unit){
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        ImageCard(
            id = meals.id,
            title = meals.name,
            painter = painterResource(meals.thumbnail),
            castigator = meals.category,
            area = meals.area,
            navigatingToRecipeDetails = navigatingToRecipeDetails
        )
    }
}

@Composable
fun ImageCard(
    id: String,
    painter: Painter,
    title: String,
    castigator: String,
    area: String,
    modifier: Modifier = Modifier,
    navigatingToRecipeDetails:(String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {navigatingToRecipeDetails(id)}),
        shape = RoundedCornerShape(8.dp)
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.8f)
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.area_24px), contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = area, color = Color.White)
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.category_24px), contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = castigator, color = Color.White)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    HomeRecipeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CategoryScreen(
                meals = homeMealsList,
                navigatingToRecipeDetails = {}
            )
        }
    }
}