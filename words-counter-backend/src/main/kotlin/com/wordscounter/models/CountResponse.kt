package com.wordscounter.models

import io.ktor.server.util.*
import io.ktor.util.date.*
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import java.time.ZoneId

@Serializable
data class CountResponse (val number: Int, val date: String = LocalDateTime.now(ZoneId.of("GMT")).toString())