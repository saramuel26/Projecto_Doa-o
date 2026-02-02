package com.prodoacao.model

import org.jetbrains.exposed.sql.Table

object Donations : Table() {
    val id = integer("id").autoIncrement()
    val donor = varchar("donor", 50)
    val item = varchar("item", 100)
    val category = varchar("category", 50)
    val quantity = integer("quantity")
    val description = varchar("description", 255)
    override val primaryKey = PrimaryKey(id)
}
