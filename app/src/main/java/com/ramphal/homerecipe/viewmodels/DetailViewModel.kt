package com.ramphal.homerecipe.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramphal.homerecipe.api.recipeDetailService
import com.ramphal.homerecipe.data.RecipeDetails
import kotlinx.coroutines.launch

class DetailViewModel(savedStateHandle: SavedStateHandle): ViewModel(){

    private val _recipeDitailState = mutableStateOf(RecipeDetailState())
    val recipeDitailState: State<RecipeDetailState> = _recipeDitailState

    init {
        val id: String? = savedStateHandle["id"]
        id?.let {
            fetchMealDetail(it)
        }

    }

    private fun fetchMealDetail(id: String){
        viewModelScope.launch {
            try {
                val response = recipeDetailService.getDetailsOfMeals(id = id)
                _recipeDitailState.value = _recipeDitailState.value.copy(
                    loading = false,
                    list = response.meals,
                    error = null
                )

            }catch (e: Exception){
                _recipeDitailState.value = _recipeDitailState.value.copy(
                    loading = false,
                    error = e.message
                )
            }
        }
    }

    data class RecipeDetailState(
        val loading: Boolean = true,
        val list: List<RecipeDetails> = emptyList(),
        val error: String? = null
    )

}