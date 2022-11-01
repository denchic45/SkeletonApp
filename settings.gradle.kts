pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.android") version "1.7.20"
        id("org.jetbrains.kotlin.jvm") version "1.7.20"
        id("com.android.library") version "7.3.1"
    }
}

rootProject.name = "SkeletonApp"

include(":app")