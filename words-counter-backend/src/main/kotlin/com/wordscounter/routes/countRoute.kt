package com.wordscounter.routes

import com.wordscounter.models.CountResponse
import com.wordscounter.utils.stripAccents
import com.wordscounter.models.Text
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import io.ktor.server.routing.post

fun Route.countRoutes(){
    route("/count"){
        countText()
    }
}

fun Route.countText(){
    post{
        val text = call.receive<Text>()

        if (text.content.length > 1000){
            return@post call.respond(HttpStatusCode.BadRequest, "text too long")
        }

        val numberOfWords = text.content.stripAccents().split(Regex("[\\w-]+")).size - 1

        return@post call.respond(CountResponse(numberOfWords))
    }
}