package dev.pula.sofrito.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NutritionInformation(
    val calories: String = "",
    val carbs: String = "",
    val cholesterol: String = "",
    val fat: String = "",
    val fiber: String = "",
    val protein: String = "",
    val saturatedFat: String = "",
    val servingSize: String = "",
    val sodium: String = "",
    val sugar: String = "",
    val transFat: String = "",
    val unsaturatedFat: String = "",
) : Parcelable
