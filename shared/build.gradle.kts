import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation("com.google.android.material:material:1.12.0")
            implementation("androidx.fragment:fragment-ktx:1.8.4")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.9.0")

            val playServicesVersion = "19.0.0"
            implementation("com.google.android.gms:play-services-maps:$playServicesVersion") {
                exclude(group = "com.android.support")
            }
            implementation("com.google.android.gms:play-services-location:21.3.0") {
                exclude(group = "com.android.support")
            }

            implementation("com.google.android.libraries.places:places:4.0.0") {
                exclude(group = "com.android.support")
            }

            implementation("com.google.maps:google-maps-services:0.2.9")

        }
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.multiplatformkickstarter.leku"
    compileSdk = 35
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
