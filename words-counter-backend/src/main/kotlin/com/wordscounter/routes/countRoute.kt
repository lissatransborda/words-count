package com.wordscounter.routes

import com.wordscounter.utils.stripAccents
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.wordscounter.models.Text

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

        return@post call.respond(text.content.stripAccents().split(Regex("[\\w-]+")).size - 1)
    }
}