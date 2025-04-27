plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.10"
}

android {
    namespace = "dev.forcetower.deeplinked"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.student.journalapp"
        minSdk = 21
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

    // NOT YET
    //ksp("com.student.journalapp.deeplink.core:deeplink-processor:1.0.0")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}