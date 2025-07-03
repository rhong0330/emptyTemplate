package com.prep.fourtytwodot.prep.data.repository

import android.util.Log
import com.prep.fourtytwodot.prep.data.model.User
import com.prep.fourtytwodot.prep.data.remote.UserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val api: UserApi) {
    fun getUsers(): Flow<List<User>> = flow {
        val response = api.getUsers()
        if (response.isSuccessful) {
            response.body()?.let {emit(it)}
        } else {
            throw Exception("${response.code()}")
        }
    }.catch { e ->
        Log.e("UserRepository","${e.message}")
        emit(emptyList())
    }
}