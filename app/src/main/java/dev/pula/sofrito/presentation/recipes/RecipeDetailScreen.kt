package dev.pula.sofrito.presentation.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.adaptive.HorizontalTwoPaneStrategy
import com.google.accompanist.adaptive.TwoPane
import dev.pula.sofrito.domain.IconContainer
import dev.pula.sofrito.domain.model.DietRestriction
import dev.pula.sofrito.domain.model.NutritionInformation
import dev.pula.sofrito.domain.model.Recipe
import dev.pula.sofrito.presentation.common.PreviewLargeDevices
import dev.pula.sofrito.presentation.theme.AppThemePreview
import java.util.Locale

@Composable
fun RecipeDetail(recipe: Recipe) {
    TwoPane(
        first = {  RecipeDetailContent(recipe = recipe) },
        second = { RecipeDetailContent(recipe = recipe) },
        strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f, gapWidth = 16.dp),
        displayFeatures = listOf(),
    )

}

@Composable
fun RecipeDetailContent(recipe: Recipe) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (overview, detail, restrictions, buttons) = createRefs()
        RecipeDetailOverview(
            modifier = Modifier.constrainAs(overview) {
                top.linkTo(parent.top)
                bottom.linkTo(detail.top)
                start.linkTo(detail.start)
                end.linkTo(detail.end)
            },
            recipe = recipe
        )
        NutritionDetail(
            modifier = Modifier.constrainAs(detail) {
                top.linkTo(overview.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(restrictions.top)
            },
            nutritionInfo = recipe.nutrition
        )
        DietRestrictions(
            modifier = Modifier.constrainAs(restrictions) {
                top.linkTo(detail.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            dietList = recipe.diet)
//        RecipeDetailButtons(
//            modifier = Modifier.constrainAs(buttons) { bottom.linkTo(parent.bottom) },
//            dividerColor = secondaryAlpha25
//        )
    }
}

@Composable
private fun RecipeDetailOverview(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    ConstraintLayout(modifier) {
        val (
            title,
            box,
            divider,
            description
        ) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(box) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
//                .size(300.dp)
                .fillMaxWidth(0.6f)
                .aspectRatio(1.0f)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.15f)),
        )
        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(box.top)
                    bottom.linkTo(divider.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = recipe.name,
            style = MaterialTheme.typography.displaySmall.merge(TextStyle(color = MaterialTheme.colorScheme.secondary, textAlign = TextAlign.Center))
        )
        Divider(
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(title.bottom)
                    start.linkTo(box.start)
                    end.linkTo(box.end)
                    width = Dimension.fillToConstraints
                }
                .height(1.dp),
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            modifier = Modifier.constrainAs(description) {
                top.linkTo(divider.bottom)
                start.linkTo(box.start, margin = 16.dp)
                end.linkTo(box.end, margin = 16.dp)
                bottom.linkTo(box.bottom)
                width = Dimension.fillToConstraints

            },
            text = recipe.description,
            style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center),
        )
    }
}

@Composable
private fun NutritionDetail(modifier: Modifier = Modifier, nutritionInfo: NutritionInformation) {
    Column(modifier) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth(0.8f)
        ) {
            val columnModifier: Modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally)
            Column(modifier = columnModifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Calories", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = nutritionInfo.calories,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
            Divider(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(modifier = columnModifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Protein", style = MaterialTheme.typography.bodyMedium)
                Text(text = nutritionInfo.protein, style = MaterialTheme.typography.titleMedium)
            }
            Divider(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(modifier = columnModifier, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Fat", style = MaterialTheme.typography.bodyMedium)
                Text(text = nutritionInfo.fat, style = MaterialTheme.typography.titleMedium)
            }
        }
        ContentDivider()
    }
}

@Composable
private fun ContentDivider() {
    Spacer(Modifier.height(12.dp))
    Divider(
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(1.dp)
    )
    Spacer(Modifier.height(12.dp))
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DietRestrictions(modifier: Modifier = Modifier, dietList: List<DietRestriction>) {
    FlowRow(
        modifier = modifier.then(
            Modifier.fillMaxWidth(0.8f)
        ),
        horizontalArrangement = Arrangement.Center,
    ) {
        dietList.forEach { DietItem(it) }
    }
}

@Composable
private fun DietItem(diet: DietRestriction) {
    val (icon, text) = diet.imageDescriptionPair()
    Row(modifier = Modifier
        .padding(start = 4.dp)
        .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        val modifier = Modifier
            .padding(4.dp)
            .size(16.dp)

        when (icon) {
            is IconContainer.ImageVectorContainer -> Icon(
                imageVector = icon.image,
                contentDescription = null,
                modifier = modifier,
                tint = MaterialTheme.colorScheme.secondary
            )
            is IconContainer.DrawableContainer -> Icon(
                painter = painterResource(id = icon.drawable),
                contentDescription = null,
                modifier = modifier,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
private fun RecipeDetailButtons(
    modifier: Modifier = Modifier,
    dividerColor: Color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.25f)
) {
    Column(modifier) {
        Spacer(Modifier.height(24.dp))
        Divider(
            color = dividerColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = "ingredients".uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = "directions".uppercase(Locale.getDefault()),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@PreviewLargeDevices
@Composable
private fun RecipeDetailPreview() {
    AppThemePreview {
        RecipeDetailContent(MockData.recipe)
    }
}
