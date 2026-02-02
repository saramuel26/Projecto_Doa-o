package com.prodoacao

import com.prodoacao.routes.userRoutes
import com.prodoacao.routes.donationRoutes
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import org.jetbrains.exposed.sql.Database

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        module()
    }.start(wait = true)
}

fun Application.module() {
    // Conexão com MySQL
    Database.connect(
        url = "jdbc:mysql://localhost:3306/prodoacao",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "doacao_user",
        password = "123456789"
    )


    install(ContentNegotiation) {
        json()
    }

    // Rotas
    userRoutes()
    donationRoutes()
}
