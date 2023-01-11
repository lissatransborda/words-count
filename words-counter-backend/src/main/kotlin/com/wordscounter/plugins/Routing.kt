package com.wordscounter.plugins

import com.wordscounter.routes.countRoutes
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        countRoutes()
    }
}
