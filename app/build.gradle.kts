
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}


android {
    namespace = "com.example.patienttracker"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.patienttracker"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    // Add this line to specify the schema export directory
    ksp {
        arg("room.schemaLocation", "/Users/devashishdayama/AndroidStudioProjects/PatientTracker/untitled folder")
    }
}
kotlin {
    jvmToolchain(17)
}



java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}
dependencies {
    ksp("androidx.room:room-compiler:2.5.2")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.06.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.navigation:navigation-runtime-ktx:2.6.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.06.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.ui:ui:1.4.3") // Replace with the latest version available
    implementation("androidx.compose.material3:material3:1.1.1") // Replace with the latest version available
    implementation("androidx.navigation:navigation-compose:2.6.0") // Replace with the latest version available
    implementation("androidx.compose.runtime:runtime-livedata:1.4.3") // Replace with the latest version available
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // Replace with the latest version available
    implementation("androidx.room:room-runtime:2.5.2") // Replace with the latest version available
    implementation ("com.google.dagger:hilt-android:2.47") // Replace with the latest version available
    ksp("com.google.dagger:hilt-android-compiler:2.47") // Replace with the latest version available
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.11")
}
    // Other dependencies...