
plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group "ru.wilddisk"
version "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("com.google.accompanist:accompanist-systemuicontroller:${properties["version.systemuicontroller"]}")
    implementation("androidx.navigation:navigation-compose:${properties["version.compose.navigation"]}")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "ru.wilddisk.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
}