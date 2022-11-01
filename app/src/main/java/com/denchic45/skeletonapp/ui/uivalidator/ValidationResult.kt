package com.denchic45.skeletonapp.ui.uivalidator

fun interface ValidationResult {
    operator fun invoke(isValid: Boolean)
}