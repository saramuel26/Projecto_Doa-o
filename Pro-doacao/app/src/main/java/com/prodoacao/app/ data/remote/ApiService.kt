package com.prodoacao.data.remote

import com.prodoacao.data.model.DonationDto
import com.prodoacao.data.model.UserDto
import retrofit2.http.*

interface ApiService {

    // ---------- USERS ----------
    @POST("users")
    suspend fun registerUser(
        @Body user: UserDto
    ): UserDto

    @GET("users")
    suspend fun getUsers(): List<UserDto>

    // ---------- DONATIONS ----------
    @GET("donations")
    suspend fun getDonations(): List<DonationDto>

    @POST("donations")
    suspend fun addDonation(
        @Body donation: DonationDto
    ): DonationDto

    @DELETE("donations/{id}")
    suspend fun deleteDonation(
        @Path("id") id: Int
    )
}
