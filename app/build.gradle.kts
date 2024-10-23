plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.banquemisrchallenge05"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.banquemisrchallenge05"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //coroutine
    kapt("androidx.room:room-compiler:2.6.1")
    implementation(libs.androidx.core.ktx)
    //room
    implementation(libs.androidx.room.runtime)
    implementation (libs.androidx.room.ktx)
    annotationProcessor(libs.androidx.room.room.compiler)
    // Retrofit
    implementation(libs.retrofit)
    // Gson
    implementation(libs.gson)
    // Retrofit Gson Converter
    implementation(libs.converter.gson)
    //view model
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    //navigation
    implementation(libs.androidx.navigation.compose)
    // Coil for image loading
    implementation(libs.coil.compose)
    // AndroidX and Robolectric
    testImplementation (libs.androidx.junit.ktx)
    //noinspection UseTomlInstead
    testImplementation ("androidx.test:core-ktx:1.6.1")
    testImplementation (libs.robolectric)
    //kotlinx-coroutines
    implementation (libs.kotlinx.coroutines.android)
    testImplementation (libs.kotlinx.coroutines.test)
    androidTestImplementation (libs.kotlinx.coroutines.test)
    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Unit Testing Libraries
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.robolectric:robolectric:4.13")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
}