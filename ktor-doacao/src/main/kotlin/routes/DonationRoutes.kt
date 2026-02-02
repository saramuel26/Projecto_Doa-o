package com.prodoacao.routes

import com.prodoacao.repository.DonationRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.donationRoutes() {
    val repository = DonationRepository()

    routing {
        route("/donations") {
            get { call.respond(repository.allDonations()) }
            get("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) return@get call.respondText("ID inválido")
                val donation = repository.findDonationById(id)
                if (donation == null) call.respondText("Doação não encontrada")
                else call.respond(donation)
            }
            delete("/{id}") {
                val id = call.parameters["id"]?.toIntOrNull()
                if (id == null) return@delete call.respondText("ID inválido")
                repository.deleteDonation(id)
                call.respondText("Doação deletada")
            }
        }
    }
}
