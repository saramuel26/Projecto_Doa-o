package com.prodoacao.model

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = integer("id").autoIncrement() // ou bigint se quiser
    val name = varchar("name", 255)
    val email = varchar("email", 255)

    override val primaryKey = PrimaryKey(id)
}