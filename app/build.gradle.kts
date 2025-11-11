plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.practica_5_listas"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.practica_5_listas"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation("junit.junit:4.13.2")
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation("android.text.espresso:espresso-core:3.5.1")

    implementation("androidx.recyclerview:recyclerview-selection:1.2.0")




}