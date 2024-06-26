plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.quocanle.letbefrienddatingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.quocanle.letbefrienddatingapp"
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

allprojects {
    repositories {
//        mavenLocal()
//        mavenCentral()
        // ADD IT HERE
//        maven { url = uri("https://jitpack.io") }
//        maven { url = uri("https://maven.google.com") }
    }
}

dependencies {
    implementation("com.google.firebase:firebase-database:20.0.3")

    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))

    // Add the dependency for the Firebase Authentication library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.android.material:material:1.4.0")

    //noinspection GradleCompatible
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.yahoo.mobile.client.android.util.rangeseekbar:rangeseekbar-library:0.1.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    //swipecard dependency
    implementation("com.lorentzos.swipecards:library:1.0.9")
    //navigation
    implementation("com.github.ittianyu:BottomNavigationViewEx:1.2.4")

    //Circle ImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

    //sliding dot splash
    implementation("com.chabbal:slidingdotsplash:1.0.2")

    //add cardview
    implementation("androidx.cardview:cardview:1.0.0")

    //glide for cache image
    implementation("com.github.bumptech.glide:glide:4.7.1")
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    annotationProcessor("com.github.bumptech.glide:compiler:4.7.1")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}