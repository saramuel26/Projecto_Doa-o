package com.prodoacao.data.repository

import com.prodoacao.data.model.UserDto
import com.prodoacao.data.remote.RetrofitInstance
import com.prodoacao.data.util.Result

class UserRepository {

    suspend fun registerUser(user: UserDto): Result<UserDto> {
        return try {
            val response = RetrofitInstance.api.registerUser(user)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao cadastrar usuário")
        }
    }

    suspend fun getUsers(): Result<List<UserDto>> {
        return try {
            val response = RetrofitInstance.api.getUsers()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar usuários")
        }
    }
}
