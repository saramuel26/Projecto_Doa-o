package com.prodoacao.repository

import com.prodoacao.model.Donations
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq


data class Donation(
    val id: Int,
    val donor: String,
    val item: String,
    val category: String,
    val quantity: Int,
    val description: String
)

class DonationRepository {

    fun allDonations(): List<Donation> = transaction {
        Donations.selectAll().map {
            Donation(it[Donations.id], it[Donations.donor], it[Donations.item], it[Donations.category], it[Donations.quantity], it[Donations.description])
        }
    }

    fun findDonationById(id: Int): Donation? = transaction {
        Donations.select { Donations.id eq id }
            .map {
                Donation(it[Donations.id], it[Donations.donor], it[Donations.item], it[Donations.category], it[Donations.quantity], it[Donations.description])
            }.singleOrNull()
    }

    fun deleteDonation(id: Int) = transaction {
        Donations.deleteWhere { Donations.id eq id }
    }
}
