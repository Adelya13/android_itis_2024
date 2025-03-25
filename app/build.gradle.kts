plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.detekt)
}

android {
    namespace = "com.example.androiditis2024"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.androiditis2024"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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

}

dependencies {

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.adapter.rxjava2)

    //okhttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //coroutines
    implementation(libs.kotlinx.coroutines.android)

    //gson
    implementation(libs.gson)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.material.v150)


}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config.setFrom("/Users/amvalisheva/AndroidStudioProjects/AndroidITIS2024/config/detekt.yml")
    baseline = file("/Users/amvalisheva/AndroidStudioProjects/AndroidITIS2024/config/baseline.xml")
}