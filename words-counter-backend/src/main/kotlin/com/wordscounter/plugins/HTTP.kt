package com.wordscounter.plugins

import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.application.Application
import io.ktor.server.application.install

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Delete)
        allowHeader(HttpHeaders.Authorization)
        allowHeader(HttpHeaders.ContentType)
        allowNonSimpleContentTypes = true
        allowSameOrigin = true
        anyHost()
    }
}
