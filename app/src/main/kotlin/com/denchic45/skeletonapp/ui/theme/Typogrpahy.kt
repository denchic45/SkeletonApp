package com.denchic45.skeletonapp.ui.theme

import androidx.compose.material3.Typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.denchic45.skeletonapp.R

val RobotoFamily = FontFamily(
    Font(R.font.roboto, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val GilroyFamily = FontFamily(
    Font(R.font.gilroy_regular, FontWeight.Normal),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold),
    Font(R.font.gilroy_bold, FontWeight.Bold)
)

val defaultTypography = Typography()

@OptIn(ExperimentalUnitApi::class)
val Typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Medium
    ),
    displayMedium = defaultTypography.displayMedium.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Normal
    ),
    displaySmall = defaultTypography.displaySmall.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Normal
    ),
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Medium
    ),
    headlineMedium = defaultTypography.headlineMedium.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Medium
    ),
    headlineSmall = defaultTypography.headlineSmall.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Medium,
        letterSpacing = TextUnit(0f, TextUnitType.Em)
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.SemiBold
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.SemiBold
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.Medium
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontFamily = GilroyFamily,
        fontWeight = FontWeight.SemiBold
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontFamily = RobotoFamily,
        fontWeight = FontWeight.Medium
    ),
)