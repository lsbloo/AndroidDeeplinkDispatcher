plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10"
    id("com.google.devtools.ksp") version "2.0.21-1.0.26"
}

android {
    namespace = "com.student.journalapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.student.journalapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

ksp {
    arg("ksp.correctErrorTypes", "true")
}

dependencies {

    implementation(libs.androidx.compose.bom)

    // Core Compose
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.runtime.livedata)

    // Activity Compose
    implementation(libs.androidx.activity.compose)

    // Lifecycle ViewModel + Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose)

    // Koin DI para Compose
    implementation(libs.koin.androidx.compose)

    // Tooling (para visualizar o Compose Preview no Android Studio)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui.tooling.preview.android)

    // IMPL CUSTOM LIB - PROCESSOR DEEPLINK DISPATCHER
    implementation(kotlin("stdlib"))
    implementation(project(mapOf("path" to ":deeplinkdispatcher", "configuration" to "default")))
    ksp(project(mapOf("path" to ":deeplinkdispatcher", "configuration" to "default")))



    // RETROFIT
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation (libs.androidx.material)
    implementation (libs.androidx.runtime.livedata.v160)
    implementation (libs.androidx.lifecycle.runtime.ktx.v261)
    implementation (libs.androidx.lifecycle.viewmodel.compose.v261)


    // KOIN
    implementation(libs.koin.androidx.compose.v200)
    implementation(libs.koin.android)

    // SERIALIZATION
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.core)

    // CORE
    implementation(project(":core"))


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}