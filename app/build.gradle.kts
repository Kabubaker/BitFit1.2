plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-parcelize")
    id ("org.jetbrains.kotlin.plugin.serialization")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.bitfit1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bitfit1"
        minSdk = 24
        targetSdk = 33
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

    buildFeatures {
        viewBinding = true
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

    val room_version = "2.4.2"
    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")

    implementation ("com.codepath.libraries:asynchttpclient:2.2.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}