plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.symbol.processing.api)
    implementation(kotlin("stdlib"))
    testImplementation(libs.junit)
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}