package com.ramphal.homerecipe.model

import com.ramphal.homerecipe.R


data class HomeMeal(
    val id: String,
    val name: String,
    val category: String,
    val area: String,
    val thumbnail: Int
)

val homeMealsList = listOf(
    HomeMeal(id = "52855", name = "Banana Pancakes", category = "Dessert", area = "American", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52856", name = "Choc Chip Pecan Pie", category = "Dessert", area = "American", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52857", name = "Pumpkin Pie", category = "Dessert", area = "American", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52858", name = "New York cheesecake", category = "Dessert", area = "American", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52859", name = "Key Lime Pie", category = "Dessert", area = "American", thumbnail = R.drawable.meal1),

    HomeMeal(id = "52861", name = "Lasagna", category = "Main Course", area = "Italian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52862", name = "Ratatouille", category = "Main Course", area = "French", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52863", name = "Paella", category = "Main Course", area = "Spanish", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52864", name = "Beef Wellington", category = "Main Course", area = "British", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52865", name = "Chicken Alfredo", category = "Main Course", area = "Italian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52866", name = "Beef Stroganoff", category = "Main Course", area = "Russian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52867", name = "Chicken Parmesan", category = "Main Course", area = "Italian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52868", name = "Shrimp Scampi", category = "Main Course", area = "Italian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52869", name = "Chicken Tikka Masala", category = "Main Course", area = "Indian", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52870", name = "Peking Duck", category = "Main Course", area = "Chinese", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52871", name = "Tom Yum Soup", category = "Soup", area = "Thai", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52872", name = "Moussaka", category = "Main Course", area = "Greek", thumbnail = R.drawable.meal1),
    HomeMeal(id = "52873", name = "Ceviche", category = "Appetizer", area = "Peruvian", thumbnail = R.drawable.meal1)
)