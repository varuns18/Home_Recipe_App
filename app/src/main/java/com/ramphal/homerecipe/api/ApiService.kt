package com.ramphal.homerecipe.api

import com.ramphal.homerecipe.data.ListOfMealsResponse
import com.ramphal.homerecipe.data.RecipeDetailResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)
val recipeDetailService = retrofit.create(ApiForRecipe::class.java)

interface ApiService {
    @GET("filter.php?c=Breakfast")
    suspend fun getListOfMeals(): ListOfMealsResponse
}

interface ApiForRecipe{
    @GET("lookup.php")
    suspend fun getDetailsOfMeals(@Query("i") id: String): RecipeDetailResponse
}
