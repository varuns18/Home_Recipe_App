package com.ramphal.homerecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ramphal.homerecipe.model.RecipeDetails
import com.ramphal.homerecipe.ui.theme.HomeRecipeTheme
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

val bodyFontFamily = FontFamily(
    Font(R.font.garamond_regular, FontWeight.Normal),
    Font(R.font.garamond_bold, FontWeight.Bold),
    Font(R.font.garamond_semibold, FontWeight.SemiBold)
)

val titleFontFamily = FontFamily(
    Font(R.font.opensans_regular, FontWeight.Normal),
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_semibold, FontWeight.SemiBold)
)

val fakeRecipeDetailResponse = listOf(
    RecipeDetails(
        idMeal = "52772",
        strMeal = "Spaghetti Carbonara",
        strMealAlternate = "Classic Carbonara",
        strCategory = "Pasta",
        strArea = "Italian",
        strInstructions = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at vestibulum sem. Nulla facilisi. Donec non tellus a tortor dictum tincidunt. Quisque varius tellus sed justo ullamcorper, et convallis odio gravida. Sed at dui fermentum, cursus purus vitae, efficitur orci. Praesent vel ligula non nulla bibendum scelerisque. Integer at odio a neque tincidunt dictum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse potenti. Nam in efficitur lorem, ac malesuada nunc. In hac habitasse platea dictumst. Donec euismod diam nec ante dictum, ut tincidunt lacus dapibus. Suspendisse interdum libero ut sapien efficitur, in convallis magna luctus. Fusce vitae ipsum ut nulla dignissim suscipit in nec augue. Curabitur fringilla urna id leo convallis, id imperdiet massa viverra. Mauris et risus a massa dignissim luctus in in mauris. Etiam ac sapien nec velit molestie pretium. Integer ac diam a felis lacinia volutpat. Pellentesque et justo et augue sagittis semper. Praesent faucibus nunc sit amet velit consectetur, non molestie nulla efficitur. Morbi tincidunt, odio in facilisis dictum, massa urna scelerisque dui, eget convallis nisl erat et urna. Nulla facilisi. Donec posuere, velit non interdum gravida, justo nulla interdum nisi, a sollicitudin risus magna vel quam. Donec a lobortis mi. Praesent vestibulum metus et nunc pharetra, in porta dui bibendum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed vitae orci ut risus efficitur ullamcorper. Cras dictum, sapien ac tempus hendrerit, ligula nisl blandit quam, nec lacinia sem dolor non leo. Aliquam erat volutpat. Quisque non dui vel nibh lacinia feugiat. Vivamus ut dictum nisl, ut fermentum purus. Nulla facilisi. Donec ac nisi ac ipsum varius finibus. Donec suscipit, lorem in pretium convallis, risus ex lacinia ipsum, vitae dictum lorem urna non mi. Curabitur vitae nibh nec nisi fermentum dignissim. Etiam congue magna purus.",        strTags = "Pasta,Italian,Classic",
        strMealThumb = "https://www.themealdb.com/images/media/meals/llcbn01574260722.jpg",
        strYoutube = "https://www.youtube.com/watch?v=3AAdKl1UYZs",
        strIngredient1 = "Spaghetti",
        strIngredient2 = "Eggs",
        strIngredient3 = "Pancetta",
        strIngredient4 = "Parmesan Cheese",
        strIngredient5 = "Black Pepper",
        strIngredient6 = "Salt",
        strIngredient7 = null,
        strIngredient8 = null,
        strIngredient9 = null,
        strIngredient10 = null,
        strIngredient11 = null,
        strIngredient12 = null,
        strIngredient13 = null,
        strIngredient14 = null,
        strIngredient15 = null,
        strIngredient16 = null,
        strIngredient17 = null,
        strIngredient18 = null,
        strIngredient19 = null,
        strIngredient20 = null,
        strMeasure1 = "200g",
        strMeasure2 = "4",
        strMeasure3 = "100g",
        strMeasure4 = "50g",
        strMeasure5 = "to taste",
        strMeasure6 = "to taste",
        strMeasure7 = null,
        strMeasure8 = null,
        strMeasure9 = null,
        strMeasure10 = null,
        strMeasure11 = null,
        strMeasure12 = null,
        strMeasure13 = null,
        strMeasure14 = null,
        strMeasure15 = null,
        strMeasure16 = null,
        strMeasure17 = null,
        strMeasure18 = null,
        strMeasure19 = null,
        strMeasure20 = null,
        strSource = "https://www.example.com/spaghetti-carbonara",
        strImageSource = "https://www.example.com/images/spaghetti-carbonara.jpg",
        strCreativeCommonsConfirmed = "Yes",
        dateModified = "2020-10-10"
    )
)

@Composable
fun DisplayMealDetails(meals: List<RecipeDetails>, navigatingToHomeScreen: () -> Unit) {
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

            Box(modifier = Modifier.fillMaxSize()) {
                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(state = scrollState)
                        .padding(top = 56.dp) // Adjust this value based on your top buttons' height
                ) {
                    Spacer(modifier = Modifier.height(210.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                HorizontalDivider(
                                    thickness = 6.dp,
                                    modifier = Modifier.fillMaxWidth(0.14f)
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                text = display.strMeal,
                                fontFamily = titleFontFamily,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(IntrinsicSize.Min)
                            ) {
                                Card(
                                    modifier = Modifier.wrapContentSize()
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        FilledTonalIconButton(
                                            onClick = {},
                                            modifier = Modifier.clickable(enabled = false, onClick = {}),
                                            shape = RoundedCornerShape(10.dp),
                                        ) {
                                            Icon(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.area_24px),
                                                contentDescription = null
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = display.strArea.toString(), fontSize = 18.sp, fontFamily = titleFontFamily, fontWeight = FontWeight.SemiBold)
                                    }
                                }
                                VerticalDivider(color = MaterialTheme.colorScheme.secondary)
                                Card(
                                    modifier = Modifier.wrapContentSize()
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        FilledTonalIconButton(
                                            onClick = {},
                                            modifier = Modifier.clickable(enabled = false, onClick = {}),
                                            shape = RoundedCornerShape(10.dp)
                                        ) {
                                            Icon(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.category_24px),
                                                contentDescription = null
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = display.strCategory.toString(), fontSize = 18.sp, fontFamily = titleFontFamily, fontWeight = FontWeight.SemiBold)
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(24.dp))
                            Text(
                                text = display.strInstructions,
                                fontFamily = bodyFontFamily,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify,
                                fontSize = 18.sp
                            )
                        }
                    }
                }

                // Overlay top row with back and favorite buttons.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilledTonalIconButton(onClick = {}, shape = RoundedCornerShape(10.dp)) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    FilledTonalIconButton(onClick = {}, shape = RoundedCornerShape(10.dp)) {
                        Icon(
                            imageVector = Icons.Rounded.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                    }
                }
            }
        }

    } else {
        // Handle the case where the desired meal is not available
        Text(text = "Meal details are not available.")
    }
}


@Preview(showBackground = true)
@Composable
fun DisplayMealDetailsPreview() {
    HomeRecipeTheme {

        Surface(modifier = Modifier.fillMaxSize()) {
            DisplayMealDetails(fakeRecipeDetailResponse, {})
        }
    }
}
