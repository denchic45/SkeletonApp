package com.denchic45.skeletonapp.ui.screen.greeting

import com.arkivanov.decompose.ComponentContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Inject


@Inject
class GreetingComponent(componentContext: ComponentContext) : ComponentContext by componentContext {
    init {
        val json = Json { prettyPrint = true }
        val strA = json.encodeToString<Structure>(Structure.A("A message"))
        println("Structure A: $strA")
        json.decodeFromString<Structure>(strA).printSelf()

        val strB = json.encodeToString<Structure>(Structure.B(148, true))
        println("Structure B: $strB")
        json.decodeFromString<Structure>(strB).printSelf()
    }
}

@Serializable
sealed class Structure {

    abstract fun printSelf()

    @Serializable
    class A(private val a: String) : Structure() {
        override fun printSelf() {
            println("a: $a")
        }
    }

    @Serializable
    class B(private val x: Int, private val y: Boolean) : Structure() {
        override fun printSelf() {
            println("x: $x y:$y")
        }
    }
}