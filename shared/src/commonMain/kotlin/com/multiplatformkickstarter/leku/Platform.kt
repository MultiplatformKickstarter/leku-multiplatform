package com.multiplatformkickstarter.leku

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform