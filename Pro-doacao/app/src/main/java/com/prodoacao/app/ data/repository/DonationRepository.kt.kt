package com.prodoacao.data.repository

import com.prodoacao.data.model.DonationDto
import com.prodoacao.data.remote.RetrofitInstance
import com.prodoacao.data.util.Result

class DonationRepository {

    suspend fun getDonations(): Result<List<DonationDto>> {
        return try {
            val response = RetrofitInstance.api.getDonations()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao carregar doações")
        }
    }

    suspend fun addDonation(donation: DonationDto): Result<DonationDto> {
        return try {
            val response = RetrofitInstance.api.addDonation(donation)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao adicionar doação")
        }
    }

    suspend fun deleteDonation(id: Int): Result<Unit> {
        return try {
            RetrofitInstance.api.deleteDonation(id)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao deletar doação")
        }
    }
}
