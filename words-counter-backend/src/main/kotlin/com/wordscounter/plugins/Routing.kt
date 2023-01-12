package com.wordscounter.plugins

import com.wordscounter.routes.countRoutes
import io.ktor.server.routing.routing
import io.ktor.server.application.Application

fun Application.configureRouting() {

    routing {
        countRoutes()
    }
}
