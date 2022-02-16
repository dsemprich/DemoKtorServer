package com.example

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import com.example.repository.NEXT_PAGE_KEY
import com.example.repository.PREVIOUS_PAGE_KEY
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.assertEquals

class ApplicationTest  {

    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    @Test
    fun `access root endpoint, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                assertEquals(
                    "Welcome to Server Api",
                    response.content
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all heroes endpoint, query all pages, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            val pages = 1..5
            val heroes = listOf(
                heroRepository.page1,
                heroRepository.page2,
                heroRepository.page3,
                heroRepository.page4,
                heroRepository.page5
            )
            pages.forEach { page ->

                handleRequest(HttpMethod.Get, "/api/heroes?page=$page").apply {
                    assertEquals(
                        HttpStatusCode.OK,
                        response.status()
                    )
                    val expected = ApiResponse(
                        success = true,
                        message = "ok",
                        prevPage = calculatePage(page)["prevPage"],
                        nextPage = calculatePage(page)["nextPage"],
                        heroes = heroes[page - 1]
                    )
                    val actual = Json.decodeFromString<ApiResponse>(response.content.toString())

                    assertEquals(
                        expected,
                        actual
                    )
                }
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all heroes endpoint, query non existing page number, assert error`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes?page=6").apply {
                assertEquals(
                    HttpStatusCode.NotFound,
                    response.status()
                )
                val expected = ApiResponse(
                    success = false,
                    message = "Heroes not Fount"
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())

                assertEquals(
                    expected,
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all heroes endpoint, query invalid page number, assert error`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes?page=invalid").apply {
                assertEquals(
                    HttpStatusCode.BadRequest,
                    response.status()
                )
                val expected = ApiResponse(
                    success = false,
                    message = "Only numbers allowed."
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())

                assertEquals(
                    expected,
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query hero name , assert single hero result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes/search?name=thor").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                    .heroes.size

                assertEquals(
                    1,
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query hero name , assert multiple heroes result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes/search?name=t").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                    .heroes.size

                assertEquals(
                    7,
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query an empty text , assert empty list as a result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes/search?name=").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                    .heroes

                assertEquals(
                    emptyList(),
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search heroes endpoint, query non existing hero , assert empty list as a result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/heroes/search?name=unknown").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                    .heroes

                assertEquals(
                    emptyList(),
                    actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access non existing endpoint, assert not found`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/api/unknown").apply {
                assertEquals(
                    HttpStatusCode.NotFound,
                    response.status()
                )
                assertEquals(
                    "Page not Found.",
                    response.content
                )
            }
        }
    }

    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

}