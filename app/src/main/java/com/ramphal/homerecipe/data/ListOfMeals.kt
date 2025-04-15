package com.ramphal.homerecipe.data

import com.google.gson.annotations.SerializedName

data class ListOfMealsResponse(
    @SerializedName("meals")
    val listOfMeals: List<ListOfMeals>
)

data class ListOfMeals(
    @SerializedName("idMeal")
    val idMeal: String,
    @SerializedName("strMeal")
    val strMeal: String,
    @SerializedName("strMealThumb")
    val strMealThumb: String
)