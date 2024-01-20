package dev.pula.sofrito.domain.model

data class Recipe(
    val name: String = "",
    val imageUrl: String = "",
    val description: String = "",
    val category: String = "",
    val nutrition: NutritionInformation = NutritionInformation(),
    val diet: List<DietRestriction> = listOf(DietRestriction.NoRestriction),
    val ingredients: List<Ingredient> = emptyList()
)
