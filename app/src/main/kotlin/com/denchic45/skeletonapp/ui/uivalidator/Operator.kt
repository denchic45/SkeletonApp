package com.denchic45.skeletonapp.ui.uivalidator

import com.denchic45.skeletonapp.ui.uivalidator.condition.Condition
import com.denchic45.skeletonapp.ui.uivalidator.validator.Validator
import com.denchic45.skeletonapp.ui.uivalidator.util.allEach
import com.denchic45.skeletonapp.ui.uivalidator.util.anyEach

fun interface Operator<T> {
    operator fun invoke(conditions: List<T>, predicate: (T) -> Boolean): Boolean

    companion object {

        fun <T> all(): Operator<T> = Operator { list, predicate -> list.all(predicate) }

        fun <T> any(): Operator<T> = Operator { list, predicate -> list.any(predicate) }

        fun <T> allEach(): Operator<T> =
            Operator { conditions, predicate -> conditions.allEach(predicate) }

        fun <T> anyEach(): Operator<T> =
            Operator { conditions, predicate -> conditions.anyEach(predicate) }
    }
}

fun <T> List<T>.validate(operator: Operator<T>, predicate: (T) -> Boolean): Boolean {
    return operator(this, predicate)
}

fun <T> List<Condition<T>>.validate(value: T, operator: Operator<Condition<T>>): Boolean {
    return operator(this) { it.validate(value) }
}

fun <T> List<Validator<out T>>.validate(operator: Operator<Validator<out T>>): Boolean {
    return operator(this) { it.validate() }
}

//fun List<Validator<*>>.validate(operator: Operator<Validator< *>>): Boolean {
//    return operator(this) { it.validate() }
//}