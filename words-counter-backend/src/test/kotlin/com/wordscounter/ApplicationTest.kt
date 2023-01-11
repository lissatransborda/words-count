package com.wordscounter

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import com.wordscounter.models.Text
import org.junit.Test
import kotlin.test.assertEquals


class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        val client = createClient {
            install(ContentNegotiation){
                json()
            }
        }
        client.post("/count") {
            contentType(ContentType.Application.Json)
            setBody(Text("my,text. have: five words"))
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("5", bodyAsText())
        }
    }
}