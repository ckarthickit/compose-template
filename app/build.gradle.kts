plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    //bikeshedding
    id("io.gitlab.arturbosch.detekt") version Versions.DetektVersion  //Static Analysis
    id("com.diffplug.spotless") version Versions.SpotlessVersion //Code Formatting
    id("install-git-hooks")
}

android {
    compileSdk = 31
    
    defaultConfig {
        applicationId = "com.ckarthickit.todo"
        minSdk = 21
        targetSdk = 31
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
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    /*composeOptions {
        kotlinCompilerExtensionVersion = compose_version
            kotlinCompilerVersion = "1.5.21"
    }*/
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

kapt {
    correctErrorTypes = true
}

//bike-shedding
detekt {
    config = files("$rootDir/config/detekt/default-detekt-config.yml")
    //Optional baseline, uncomment & run gradle command detektBaseline to exclude existing issues
    //baseline = file("detekt-baseline.xml")
}

spotless {
    //To disable adding spotless as dependency to "check" - task un-comment below code.
    //enforceCheck false
    java {
        target("**/*.java")
        googleJavaFormat("1.8").aosp().reflowLongStrings()
        setEncoding("Cp1252")  // java will have Cp1252
    }
    
    kotlin {
        target("**/*.kt")
        // Optional user arguments can be set as such:
        //TODO: For some reasons , ktlint is not picking up editorconfig, figureout passing editorconfig File
        ktlint("0.43.0").userData(mapOf("indent_size" to "2", "continuation_indent_size" to "4"))
        trimTrailingWhitespace()
        //replaceRegex 'Remove empty lines before end of block', '\\n[\\n]+(\\s*})(?=\\n)', '\n$1'
        //replaceRegex 'Remove trailing empty comment lines.', '\n\\s*\\*(\n\\s*\\*/\n)', '$1'
    }
}

dependencies {
    
    implementation(Deps.AndroidX.coreKotlinExtensions)
    implementation(Deps.AndroidX.appCompat)
    //AndroidX Lifecycle Runtime
    implementation(Deps.AndroidX.Lifecycle.runtimeKTX)
    //Use Google Material Design
    implementation(Deps.googleMaterialDesign)
    
    //Use Jetpack Compose
    implementation(Deps.Compose.UI)
    implementation(Deps.Compose.MaterialUI)
    implementation(Deps.Compose.UIToolingPreview)
    debugImplementation(Deps.Compose.UITooling)
    implementation(Deps.Compose.Activity)
    
    // Use Kotlin Coroutines
    implementation(Deps.KotlinX.Coroutines)
    
    //Use Retrofit for NW Calls
    implementation(Deps.Networking.Retrofit.Core)
    //Retrofit Converters
    implementation(Deps.Networking.Retrofit.ConverterScalar)
    implementation(Deps.Networking.Retrofit.ConverterMoshi)
    //implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation(Deps.Networking.Retrofit.Mock)
    
    //OkHttp and it's interceptors
    implementation(Deps.Networking.OkHttp.Core)
    implementation(Deps.Networking.OkHttp.Logging)
    implementation(Deps.Networking.OkHttp.MockWebServer)
    
    //Use Moshi for Serialization / De-Serialization
    implementation(Deps.Networking.Moshi.Core)
    implementation(Deps.Networking.Moshi.Adapter)
    kapt(Deps.Networking.Moshi.CodeGen)
    
    //Hilt for DI
    implementation(Deps.Hilt.CoreAndroid)
    kapt(Deps.Hilt.Compiler)
    // Hilt ViewModel extension
    implementation(Deps.Hilt.AndroidLifecycle)
    kapt(Deps.Hilt.AndroidCompiler)
    
    // Use the Kotlin test library.
    testImplementation(Deps.Test.KotlinX.KotlinTest)
    // Use the Kotlin JUnit integration.
    testImplementation(Deps.Test.KotlinX.KotlinTestJunit)
    
    testImplementation(Deps.Test.junit4)
    androidTestImplementation(Deps.Test.junitExt)
    androidTestImplementation(Deps.Test.espressoCore)
    androidTestImplementation(Deps.Test.Compose.UITest)
    
}