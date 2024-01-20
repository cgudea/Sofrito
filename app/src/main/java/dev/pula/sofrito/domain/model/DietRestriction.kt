package dev.pula.sofrito.domain.model

import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Bomb
import compose.icons.fontawesomeicons.solid.Cookie
import compose.icons.fontawesomeicons.solid.MehBlank
import compose.icons.fontawesomeicons.solid.Om
import compose.icons.fontawesomeicons.solid.StarAndCrescent
import compose.icons.fontawesomeicons.solid.StarOfDavid
import dev.pula.sofrito.R
import dev.pula.sofrito.domain.IconContainer

enum class DietRestriction(diet: String) {
    NoRestriction("NoDiet"),
    DiabeticDiet("DiabeticDiet"),
    GlutenFreeDiet("GlutenFreeDiet"),
    HalalDiet("HalalDiet"),
    HinduDiet("HinduDiet"),
    KosherDiet("KosherDiet"),
    LowCalorieDiet("LowCalorieDiet"),
    LowFatDiet("LowFatDiet"),
    LowLactoseDiet("LowLactoseDiet"),
    LowSaltDiet("LowSaltDiet"),
    VeganDiet("VeganDiet"),
    VegetarianDiet("VegetarianDiet");

    fun imageDescriptionPair(): Pair<IconContainer, String> =
        when (this) {
            NoRestriction -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.MehBlank),
                ""
            )
            DiabeticDiet -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.Bomb),
                "Diabetic Friendly"
            )
            GlutenFreeDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_gluten_free),
                "Gluten Free"
            )
            HalalDiet -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.StarAndCrescent),
                "Halal"
            )
            HinduDiet -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.Om),
                "Hindu Vegetarian"
            )
            KosherDiet -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.StarOfDavid),
                "Kosher"
            )
            LowCalorieDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_kitchen_scale),
                "Low Cal"
            )
            LowFatDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_kitchen_scale),
                "Low Fat"
            )
            LowLactoseDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_lactose_free),
                "Lactose Free"
            )
            LowSaltDiet -> Pair(
                IconContainer.ImageVectorContainer(FontAwesomeIcons.Solid.Cookie),
                "Low Salt"
            )
            VeganDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_meat2),
                "Vegan"
            )
            VegetarianDiet -> Pair(
                IconContainer.DrawableContainer(R.drawable.ic_seafood),
                "Vegetarian"
            )
        }
}