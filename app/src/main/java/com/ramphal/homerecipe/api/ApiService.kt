package com.ramphal.homerecipe.api

import com.ramphal.homerecipe.model.RecipeDetailResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.jvm.java

private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeDetailService = retrofit.create(ApiForRecipe::class.java)

interface ApiForRecipe{
    @GET("lookup.php")
    suspend fun getDetailsOfMeals(@Query("i") id: String): RecipeDetailResponse
}
