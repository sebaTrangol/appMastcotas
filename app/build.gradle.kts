plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.myapplication" // Esto está bien
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication" // Cambia esto para que coincida con el namespace
        minSdk = 24
        targetSdk = 34
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Dependencias de AndroidX

    // AppCompat para soporte de compatibilidad hacia atrás con componentes de UI
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Design Components (sustituye a android.support.design)
    implementation("com.google.android.material:material:1.9.0")

    // ConstraintLayout (sustituye a android.support.constraint.ConstraintLayout)
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // ContextCompat (sustituye a android.support.v4.content.ContextCompat)
    implementation("androidx.core:core-ktx:1.10.1")

    // RecyclerView (sustituye a android.support.v7.widget.RecyclerView)
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Room para la base de datos
    implementation("androidx.room:room-runtime:2.5.0")
    annotationProcessor("androidx.room:room-compiler:2.5.0") // Para Java

    implementation("com.google.code.gson:gson:2.8.9")


    // Dependencias para pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}