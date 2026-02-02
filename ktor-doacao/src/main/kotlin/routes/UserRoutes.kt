package com.prodoacao.routes

import com.prodoacao.repository.UserRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRoutes() {
    val repository = UserRepository()

    routing {
        route("/users") {
            get { call.respond(repository.allUsers()) }
            get("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) return@get call.respondText("ID inválido")
                val user = repository.findUserById(id)
                if (user == null) call.respondText("Usuário não encontrado")
                else call.respond(user)
            }
            delete("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) return@delete call.respondText("ID inválido")
                repository.deleteUser(id)
                call.respondText("Usuário deletado")
            }
        }
    }
}
