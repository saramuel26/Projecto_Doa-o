package com.prodoacao.repository
import com.prodoacao.model.Users
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserRepository {

    fun allUsers(): List<ResultRow> = transaction {
        Users.selectAll().toList()
    }

    fun findUserById(id: Int): ResultRow? = transaction {
        Users.select { Users.id eq id }.singleOrNull()
    }

    fun deleteUser(id: Int) = transaction {
        Users.deleteWhere { Users.id eq id }
    }


    fun addUser(name: String, email: String) = transaction {
        Users.insert { stmt ->
            stmt[Users.name] = name
            stmt[Users.email] = email
        }
    }
}
