plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.hyundai.pokedex.core"
    compileSdk = 34

    defaultConfig {
        minSdk = 34

        testInstrumentationRunner = "com.hyundai.pokedex.core.di.PokedexTestRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.test:runner:1.5.2")
    implementation("androidx.paging:paging-common-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.google.dagger:hilt-android:2.49")
    kapt("com.google.dagger:hilt-android-compiler:2.49")
    testImplementation("com.google.dagger:hilt-android-testing:2.49")
    kaptTest("com.google.dagger:hilt-android-compiler:2.49")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.49")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.49")
}
