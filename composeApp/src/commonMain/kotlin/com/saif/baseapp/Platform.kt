package com.saif.baseapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform