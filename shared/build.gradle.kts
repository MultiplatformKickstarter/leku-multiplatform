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
            implementation(libs.material)
            implementation(libs.compose.material3)
            implementation(libs.androidx.fragment.ktx)
            implementation(libs.kotlinx.coroutines.guava)

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

            implementation(libs.google.maps.services)
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
