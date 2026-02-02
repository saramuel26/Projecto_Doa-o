package com.prodoacao.data.model

data class DonationDto(
    val id: Int,
    val donor: String,
    val item: String,
    val category: String,
    val quantity: Int,
    val description: String
)
