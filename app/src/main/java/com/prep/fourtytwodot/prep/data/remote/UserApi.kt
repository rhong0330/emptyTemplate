package com.prep.fourtytwodot.prep.data.remote

import com.prep.fourtytwodot.prep.data.model.User
import retrofit2.Response
import retrofit2.http.GET


interface UserApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}