package com.prodoacao.models

data class UserDTO(val id: Int = 0, val name: String, val email: String)
data class DonationDTO(
    val id: Int = 0,
    val donorId: Int,
    val item: String,
    val category: String,
    val quantity: Int,
    val description: String? = null
)
