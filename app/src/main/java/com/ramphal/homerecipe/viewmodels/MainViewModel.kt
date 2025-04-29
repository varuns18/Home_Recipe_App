package com.ramphal.homerecipe.viewmodels

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ramphal.homerecipe.model.HomeMeal
import com.ramphal.homerecipe.model.homeMealsList

class MainViewModel: ViewModel() {

    private val _mealsListState = mutableStateOf(RecipeState())
    val mealsListState: State<RecipeState> = _mealsListState

    @Immutable
    data class RecipeState(
        val loading: Boolean = false,
        val list: List<HomeMeal> = homeMealsList,
        val error: String? = null
    )

}