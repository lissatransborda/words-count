package com.wordscounter

import com.wordscounter.models.CountResponse
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import com.wordscounter.models.Text
import io.ktor.client.call.*
import org.junit.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals


class ApplicationTest {
    @Test
    fun testCountRoute() = testApplication {
        val client = createClient {
            install(ContentNegotiation){
                json()
            }
        }
        client.post("/count") {
            contentType(ContentType.Application.Json)
            setBody(Text("my,text. have: five words"))
        }.apply {
            val response = body<CountResponse>()
            println()
            assertEquals(HttpStatusCode.OK, status)
            assertEquals(5, response.number)
        }

        client.post("/count") {
            contentType(ContentType.Application.Json)
            setBody(Text("a".repeat(1001)))
        }.apply{
            assertEquals(HttpStatusCode.BadRequest, status)
            assertEquals("text too long", bodyAsText())
        }
    }
}