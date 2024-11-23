import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val properties = Properties().apply {
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "com.example.travelapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.travelapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "KAKAO_MAP_KEY", properties.getProperty("KAKAO_MAP_KEY"))
        buildConfigField("String", "KAKAO_REST_API_KEY", properties.getProperty("KAKAO_REST_API_KEY"))

        ndk {
            abiFilters.add("arm64-v8a")
            abiFilters.add("armeabi-v7a")
            abiFilters.add("x86")
            abiFilters.add("x86_64")
        }
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
        buildConfig = true
    }
    viewBinding.isEnabled = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    // AndroidX 및 Android 기본 라이브러리
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")

    // 카카오 SDK 추가
    implementation("com.kakao.sdk:v2-user:2.20.6") // 카카오 로그인 SDK
    implementation ("com.kakao.maps.open:android:2.12.8")

    // firebase sdk 추가
    //implementation(libs.firebase.auth)
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))    // Firebase BoM을 추가하여 Firebase 라이브러리 버전을 관리
    implementation("com.google.firebase:firebase-firestore-ktx")            // Firebase Firestore SDK 추가
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")


    //카카오 REST API 호출용
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")


    // 테스트 및 Android 테스트 라이브러리
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation ("com.google.code.gson:gson:2.10.1")
}

