package com.ramphal.homerecipe.viewmodels

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramphal.homerecipe.data.ListOfMeals
import com.ramphal.homerecipe.api.recipeService
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _mealsListState = mutableStateOf(RecipeState())
    val mealsListState: State<RecipeState> = _mealsListState

    init {
        fetchMealList()
    }

    private fun fetchMealList(){
        viewModelScope.launch {
            try {
                val response = recipeService.getListOfMeals()
                _mealsListState.value = _mealsListState.value.copy(
                    list = response.listOfMeals,
                    loading = false,
                    error = null
                )

            }catch (e: Exception){
                _mealsListState.value = _mealsListState.value.copy(
                    loading = false,
                    error = "Error fatching categories ${e.message}"
                )
            }
        }
    }

    @Immutable
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<ListOfMeals> = emptyList(),
        val error: String? = null
    )

}