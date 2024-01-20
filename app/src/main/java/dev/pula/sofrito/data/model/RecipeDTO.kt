package dev.pula.sofrito.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.pula.sofrito.domain.model.DietRestriction
import dev.pula.sofrito.domain.model.NutritionInformation
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RecipeDTO(
    @Json(name = "aggregateRating") val aggregateRating: AggregateRating = AggregateRating(),
    @Json(name = "author") val recipeAuthor: RecipeAuthor = RecipeAuthor(),
    @Json(name = "cookTime") val cookTime: String = "",
    @Json(name = "dateModified") val dateModified: String = "",
    @Json(name = "datePublished") val datePublished: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "image") val image: String = "",
    @Json(name = "keywords") val keywords: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "nutrition") val nutrition: NutritionInformation = NutritionInformation(),
    @Json(name = "prepTime") val prepTime: String = "",
    @Json(name = "recipeCategory") val recipeCategories: List<RecipeCategory> = emptyList(),
    @Json(name = "recipeCuisine") val recipeCuisine: String = "",
    @Json(name = "recipeIngredient") val recipeIngredient: List<String> = emptyList(),
    @Json(name = "recipeInstructions") val recipeInstructions: List<String> = emptyList(),
    @Json(name = "recipeYield") val recipeYield: Int = 0,
    @Json(name = "suitableForDiet") val suitableForDiet: List<DietRestriction> = listOf(DietRestriction.NoRestriction),
    @Json(name = "totalTime") val totalTime: String = "",
    @Json(name = "url") val url: String = ""
) : Parcelable {

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class RecipeAuthor(
        @Json(name = "description") val description: String = "",
        @Json(name = "jobTitle") val jobTitle: String = "",
        @Json(name = "name") val name: String = "",
        @Json(name = "sameAs") val sameAs: List<String> = emptyList(),
        @Json(name = "url") val url: String = ""
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class AggregateRating(
        @Json(name = "ratingCount") val ratingCount: String = "",
        @Json(name = "ratingValue") val ratingValue: String = ""
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Nutrition(
        @Json(name = "calories") val calories: String = "",
        @Json(name = "carbohydrateContent") val carbs: String = "",
        @Json(name = "cholesterolContent") val cholesterol: String = "",
        @Json(name = "fatContent") val fat: String = "",
        @Json(name = "fiberContent") val fiber: String = "",
        @Json(name = "proteinContent") val protein: String = "",
        @Json(name = "saturatedFatContent") val saturatedFat: String = "",
        @Json(name = "servingSize") val servingSize: String = "",
        @Json(name = "sodiumContent") val sodium: String = "",
        @Json(name = "sugarContent") val sugar: String = "",
        @Json(name = "transFatContent") val transFat: String = "",
        @Json(name = "unsaturatedFatContent") val unsaturatedFat: String = "",
    ) : Parcelable

    @Parcelize
    data class RecipeCategory(
        val name: String
    ) : Parcelable
}