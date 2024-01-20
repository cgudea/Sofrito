package dev.pula.sofrito.presentation.recipes

import dev.pula.sofrito.domain.model.DietRestriction
import dev.pula.sofrito.domain.model.Ingredient
import dev.pula.sofrito.domain.model.NutritionInformation
import dev.pula.sofrito.domain.model.Recipe

object MockData {
    val recipe = Recipe(
        name = "Creamy Pesto\n Pasta",
        description = "Guilt-free gluten-free spaghetti pasta is sautéed in a garlic kale pesto. It's an easy and healthy dinner.",
        nutrition = NutritionInformation(
            calories = "880 cal",
            protein = "24g",
            fat = "12g"
        ),
        diet = listOf(
            DietRestriction.DiabeticDiet,
            DietRestriction.GlutenFreeDiet,
            DietRestriction.HalalDiet,
            DietRestriction.HinduDiet,
            DietRestriction.KosherDiet,
            DietRestriction.LowCalorieDiet,
            DietRestriction.LowFatDiet,
            DietRestriction.LowLactoseDiet,
            DietRestriction.LowSaltDiet,
            DietRestriction.VeganDiet,
            DietRestriction.VegetarianDiet,
        ),
        ingredients = listOf(
            Ingredient(name = "Garlic", amount = "2 cloves"),
            Ingredient(name = "Olive Oil", amount = "12 tbsp"),
            Ingredient(name = "Red Pepper Flakes", amount = "5g"),
            Ingredient(name = "Basil", amount = "56g"),
            Ingredient(name = "Salt", amount = "10g"),
            Ingredient(name = "Pepper", amount = "3g"),
            Ingredient(name = "Spaghetti Noodles", amount = "200g"),
        )
    )

    val shoppingList = listOf(
        Ingredient(name = "wine vinegar", amount = "1 cup"),
        Ingredient(name = "tomato paste", amount = "450g"),
        Ingredient(name = "celery", amount = "2 bunches"),
        Ingredient(name = "octopus", amount = "2 lbs"),
        Ingredient(name = "peaches", amount = "4 lbs"),
        Ingredient(name = "maple syrup", amount = "2 cups"),
        Ingredient(name = "condensed milk", amount = "1 cup"),
        Ingredient(name = "portabella mushrooms", amount = "450g"),
        Ingredient(name = "clams", amount = "3 lbs"),
        Ingredient(name = "prunes", amount = "200g"),
        Ingredient(name = "cream cheese", amount = "1 cup"),
        Ingredient(name = "olives", amount = "800g"),
        Ingredient(name = "molasses", amount = "1/2 cup"),
        Ingredient(name = "paprika", amount = "4 tbsp"),
        Ingredient(name = "eggs", amount = "2 dozen"),
        Ingredient(name = "cider", amount = "5 cups"),
        Ingredient(name = "sherry", amount = "1 cup"),
        Ingredient(name = "rabbits", amount = "3 lbs"),
        Ingredient(name = "chickpeas", amount = ""),
        Ingredient(name = "wasabi", amount = "20kg"),
        Ingredient(name = "cornmeal", amount = "15 oz"),
        Ingredient(name = "chestnuts", amount = "90g"),
        Ingredient(name = "bean sprouts", amount = "2 bunches"),
        Ingredient(name = "cantaloupes", amount = "3 whole fruit"),
        Ingredient(name = "apricots", amount = "390g"),
        Ingredient(name = "blueberries", amount = "15lbs"),
        Ingredient(name = "Havarti cheese", amount = "8oz"),
        Ingredient(name = "pepper", amount = "18kg"),
        Ingredient(name = "romaine lettuce", amount = "1 leaf"),
        Ingredient(name = "buttermilk", amount = "14 gallons"),
        Ingredient(name = "unsweetened chocolate", amount = "2 bars"),
        Ingredient(name = "sardines", amount = "3 fillets"),
        Ingredient(name = "curry paste", amount = "1 tsp"),
        Ingredient(name = "parsnips", amount = "9"),
        Ingredient(name = "peanut butter", amount = "8 cups"),
        Ingredient(name = "almond paste", amount = "2 tsp"),
        Ingredient(name = "Worcestershire sauce", amount = "7oz"),
        Ingredient(name = "cranberries", amount = "3 cups"),
        Ingredient(name = "ancho chile peppers", amount = "2 peppers"),
        Ingredient(name = "trout", amount = "2 fillets"),
    )
}