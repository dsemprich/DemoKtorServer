package com.example.plugins

import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {

        static {
            resources("static")
        }
        get("/") {
            call.respondText("Hello World!")
        }
        get("/welcome") {
            call.respondText(" Welcome!")
        }
    }
}

@Suppress("unused")
@Serializable
data class Person(
    val name: String,
    val age: Int
)