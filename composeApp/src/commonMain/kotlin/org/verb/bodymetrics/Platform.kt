package org.verb.bodymetrics

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform