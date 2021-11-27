object Versions {
    const val androidBuildToolsPlugin = "7.0.2"
    const val kotlin = "1.5.21"
    const val coroutinesVersion = "1.5.1"
    
    const val composeVersion = "1.0.1"
    
    const val timberLibraryVersion = "4.7.1"
    
    const val materialDesignVersion = "1.4.0"
    
    //Networking
    const val okHttpVersion = "4.3.1"
    const val retrofitVersion = "2.9.0"
    const val moshiVersion = "1.12.0"
    
    //DI
    const val hilt = "2.38.1"
    const val hiltLifecycle = "1.0.0"
    
    const val androidXLifecycle = "2.4.0"
    
    //BikeShedding
    const val DetektVersion = "1.18.1"
    const val SpotlessVersion = "5.15.1"
}

enum class BuildScriptPlugins(val artifact: String) {
    ANDROID_BUILD_TOOLS("com.android.tools.build:gradle:${Versions.androidBuildToolsPlugin}"),
    KOTLIN("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"),
    HILT("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
}

object Deps {
    const val googleMaterialDesign =
        "com.google.android.material:material:${Versions.materialDesignVersion}"
    const val timberLib = "com.jakewharton.timber:timber:${Versions.timberLibraryVersion}"
    
    object Compose {
        const val Foundation =
            "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val UITooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
        const val UIToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val UI = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val MaterialUI = "androidx.compose.material:material:${Versions.composeVersion}"
        
        //Compose  Runtime  => has getValue , setValue delegates and mutableStateOf APIs
        const val Runtime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
        
        //Compose Runtime LiveDate => Has observeAsState
        const val RuntimeLiveData =
            "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
    
        const val Activity = "androidx.activity:activity-compose:1.4.0"
    }
    
    //https://developer.android.com/jetpack/androidx/versions/stable-channel
    object AndroidX {
        const val coreKotlinExtensions = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.0"
        
        
        object Lifecycle {
            const val runtimeKTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidXLifecycle}"
    
            @Suppress("unused")
            const val viewModelKTX =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidXLifecycle}"
    
            @Suppress("unused")
            const val liveDataKTX =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidXLifecycle}"
        }
        
        const val fragmentKTX = "androidx.fragment:fragment-ktx:1.3.5"
    }
    
    object KotlinX {
        const val Coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    }
    
    // Testing Libraries
    object Test {
        const val junit4 = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        object Compose {
            const val UITest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
        }
        object KotlinX {
            const val KotlinTest = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
            const val KotlinTestJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
        }
    }
    
    object Networking {
        object Retrofit {
            const val Core = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
            const val ConverterScalar =
                "com.squareup.retrofit2:converter-scalars:${Versions.retrofitVersion}"
            const val ConverterMoshi =
                "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
            const val Mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofitVersion}"
        }
        
        object OkHttp {
            const val Core = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
            const val Logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
            const val MockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttpVersion}"
        }
        
        object Moshi {
            const val Core = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
            const val Adapter = "com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}"
            const val CodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"
        }
    }
    
    object Hilt {
        const val CoreAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val Compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        
        //Hilt Extensions
        const val AndroidLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val AndroidCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltLifecycle}"
    }
}