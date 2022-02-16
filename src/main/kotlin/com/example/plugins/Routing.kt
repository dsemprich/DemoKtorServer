package com.example.plugins

import com.example.routes.getAllHeroes
import com.example.routes.root
import com.example.routes.searchHeroes
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {

        static {
            resources("static")
        }
        static("/images") {
            resources("images")
        }
        root()
        getAllHeroes()
        searchHeroes()
    }
}