package com.fourtytwodot.prep.data.repository

import com.fourtytwodot.prep.data.model.User
import com.fourtytwodot.prep.data.remote.UserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: UserApi){
    fun getUsers(): Flow<List<User>> = flow {
        val response = api.getUsers()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it)
            }
        } else {
            throw Exception("API Error")
        }
    }.catch {
        emit(emptyList())
    }
}