package com.example.plugins

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.*
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
            val name = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title {
                        +"Custom Title"
                    }
                }
                body {
                    if (name.isNullOrEmpty()) {
                        h3 { +"Welcome!" }
                    } else {
                        h3 { +"Welcome, $name" }
                    }
                    p { +"Current directory is: ${System.getProperty("user.dir")}" }
                    img(src = "logo.png")
                }
            }
        }


    }
}

@Suppress("unused")
@Serializable
data class Person(
    val name: String,
    val age: Int
)